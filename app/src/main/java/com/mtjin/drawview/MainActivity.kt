package com.mtjin.drawview

import android.Manifest
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import com.mtjin.library.DrawView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var drawView: DrawView
    lateinit var imageView: ImageView
    private lateinit var permissionListener: PermissionListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawView = findViewById(R.id.drawView)
        imageView = findViewById(R.id.iv_bitmap)

        // request permisson for getFile()
        permissionListener = object : PermissionListener {
            override fun onPermissionGranted() {
            }

            override fun onPermissionDenied(deniedPermissions: ArrayList<String>?) {
                TedPermission.with(this@MainActivity)
                    .setPermissionListener(permissionListener)
                    .setRationaleMessage("REQUEST AUTH")
                    .setDeniedMessage("DENY")
                    .setPermissions(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    )
                    .check()
            }
        }
        TedPermission.with(this)
            .setPermissionListener(permissionListener)
            .setRationaleMessage("REQUEST AUTH")
            .setDeniedMessage("DENIED")
            .setPermissions(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
            .check()
    }

    fun color(view: View) {
        drawView.setPenColor(Color.parseColor("#D81B60"))
    }

    fun stroke(view: View) {
        drawView.setStrokeWidth(20f)
    }

    fun redo(view: View) {
        drawView.redo()
    }

    fun undo(view: View) {
        drawView.undo()
    }

    fun clear(view: View) {
        drawView.clear()
    }

    //get draw line Bitmap from drawView then set it on ImageView
    fun getDrawLineBitmap(view: View) {
        val bitmap = drawView.getBitmapDrawLine()
        imageView.setImageBitmap(bitmap)
    }

    // get draw line to File
    fun getBitmap(view: View) {
        val bitmap = drawView.getBitmap()
        imageView.setImageBitmap(bitmap)
    }

    // save File and get the Uri, it needs WRITE_EXTERNAL_STORAGE permission
    fun getFileAndGetUri(view: View) {
        drawView.saveFileDrawViewGetUri()
    }
}
