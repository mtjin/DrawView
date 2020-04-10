package com.mtjin.library

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.ContextWrapper
import android.graphics.*
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.util.AttributeSet
import android.util.Pair
import android.view.MotionEvent
import android.view.View
import androidx.core.view.drawToBitmap
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class DrawView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private var mContext: Context = context
    private var mPen: Pen
    private var mPath: Path = Path()
    private var mPathList
            : ArrayList<Pair<Path, Pen>>? = null
    private var mRedoList
            : Stack<Pair<Path, Pen>>? = null

    init {
        mPen = Pen()
        mPathList = ArrayList()
        mRedoList = Stack()
        attrs?.let { initPaint(it) }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint: Paint = mPen.mPaint
        for (p in this.mPathList!!) {
            canvas!!.drawPath(p.first!!, p.second.mPaint)
        }
        canvas?.drawPath(mPath, paint)
    }

    //called when screen is touched or untouched
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val X: Float = event.x
        val Y: Float = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> mPath.moveTo(X, Y)
            //draw line
            MotionEvent.ACTION_MOVE -> mPath.lineTo(X, Y)
            // save history
            MotionEvent.ACTION_UP -> {
                val pair =
                    Pair(mPath, mPen)
                mPathList?.add(pair)
                mPath = Path()
                val penColor = mPen.mColor
                val penStrokeWidth: Float = mPen.mStrokeWidth
                mPen = Pen()
                mPen.setPenColor(penColor)
                mPen.setStrokeWidth(penStrokeWidth)
            }
        }
        invalidate()
        return true
    }

    // init first from xml attrs
    private fun initPaint(atr: AttributeSet) {
        mPen = Pen()
        val typedArray =
            mContext.theme.obtainStyledAttributes(atr, R.styleable.DrawView, 0, 0)
        val drawViewPenColor = typedArray.getString(R.styleable.DrawView_pen_color)
        val drawViewPenStroke = typedArray.getString(R.styleable.DrawView_pen_stroke)
        drawViewPenColor?.let {
            mPen.setPenColor((Color.parseColor(it)))
        }
        drawViewPenStroke?.let {
            mPen.setStrokeWidth(drawViewPenStroke.toFloat())
        }
    }

    //UnDo the last change done
    fun undo() {
        if (mPathList?.size ?: -1 >= 1) {
            mRedoList?.push(mPathList?.get(mPathList!!.size - 1))
            mPathList?.removeAt(mPathList!!.size - 1)
            invalidate()
        }
    }

    //ReDo the last change done
    fun redo() {
        if (!mRedoList?.empty()!!) {
            mRedoList?.peek()?.let { mPathList?.add(it) }
            mRedoList!!.pop()
            invalidate()
        }
    }

    // get only draw line bitmap except background
    fun getBitmapDrawLine(): Bitmap {
        val color = (this.background as ColorDrawable).color
        this.setBackgroundColor(Color.parseColor("#00000000"))
        val bitmap = this.drawToBitmap()
        this.setBackgroundColor(color)
        return bitmap
    }

    // get whole drawView to bitmap
    fun getBitmap(): Bitmap {
        return this.drawToBitmap()
    }

    // get DrawLine to File and return Uri
    @SuppressLint("WrongThread", "SimpleDateFormat")
    fun saveFileDrawLineGetUri(): Uri? {
        val mTimeStamp: String = SimpleDateFormat("ddMMyyyy_HHmm").format(Date())
        val mImageName = "drawView_$mTimeStamp.jpg"
        val wrapper = ContextWrapper(mContext)
        var file = wrapper.getDir("Images", MODE_PRIVATE)
        file = File(file, "drawView_$mImageName.jpg")
        try {
            var stream: OutputStream? = null
            stream = FileOutputStream(file)
            getBitmapDrawLine().compress(Bitmap.CompressFormat.JPEG, 100, stream)
            stream.flush()
            stream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return Uri.parse(file.absolutePath)
    }

    // get whole drawView to File and return Uri
    @SuppressLint("WrongThread", "SimpleDateFormat")
    fun saveFileDrawViewGetUri(): Uri? {
        val mTimeStamp: String = SimpleDateFormat("ddMMyyyy_HHmm").format(Date())
        val mImageName = "drawView_$mTimeStamp.jpg"
        val wrapper = ContextWrapper(mContext)
        var file = wrapper.getDir("Images", MODE_PRIVATE)
        file = File(file, "drawView_$mImageName.jpg")
        try {
            var stream: OutputStream? = null
            stream = FileOutputStream(file)
            getBitmapDrawLine().compress(Bitmap.CompressFormat.JPEG, 100, stream)
            stream.flush()
            stream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return Uri.parse(file.absolutePath)
    }


    // clear draw line from the screen
    fun clear() {
        mRedoList?.clear()
        for (p in mPathList!!) {
            mRedoList?.push(p)
        }
        mPathList?.clear()
        invalidate()
    }

    // set Pen Color
    fun setPenColor(penColor: Int) {
        mPen.setPenColor(penColor)
    }

    // set Pen Stroke Width
    fun setStrokeWidth(penStroke: Float) {
        mPen.setStrokeWidth(penStroke)
    }

}