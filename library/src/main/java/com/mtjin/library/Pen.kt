package com.mtjin.library

import android.graphics.Color
import android.graphics.Paint
import android.util.Log

class Pen {
    var mPaint: Paint = Paint()
    var mColor = Color.parseColor("#000000")
    var mStrokeWidth: Float = 3f

    // init pen attribute
    init {
        mPaint.color = mColor
        mPaint.strokeWidth = mStrokeWidth
        mPaint.isAntiAlias = true
        mPaint.strokeJoin = Paint.Join.ROUND
        mPaint.strokeCap = Paint.Cap.ROUND
        mPaint.style = Paint.Style.STROKE
    }


    // set pen Color
    fun setPenColor(penColor: Int) {
        try {
            mPaint.color = penColor
            mColor = penColor
        } catch (e: Exception) {
            Log.d(TAG, e.toString())
        }
    }

    // set pen stroke width
    fun setStrokeWidth(strokeWidth: Float) {
        mPaint.strokeWidth = strokeWidth
        mStrokeWidth = strokeWidth
    }

    companion object {
        const val TAG = "Pen"
    }
}