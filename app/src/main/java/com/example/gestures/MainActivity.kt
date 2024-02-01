package com.example.gestures

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    var gDetector: GestureDetectorCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.gDetector = GestureDetectorCompat(this,this)
        gDetector?.setOnDoubleTapListener(this)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            this.gDetector?.onTouchEvent(event)
        }
        return super.onTouchEvent(event)
    }
// click pressed down
    override fun onDown(p0: MotionEvent): Boolean {

        return true
    }

    override fun onShowPress(p0: MotionEvent) {

    }
// click released
    override fun onSingleTapUp(p0: MotionEvent): Boolean {

        return true
    }
// click and drag
    override fun onScroll(e1: MotionEvent?, p0: MotionEvent, p2: Float, p3: Float): Boolean {

        return true
    }

    override fun onLongPress(p0: MotionEvent) {
        Toast.makeText(this, "Pet pet", Toast.LENGTH_SHORT).show()
    }

    override fun onFling(p0: MotionEvent?, p1: MotionEvent, p2: Float, p3: Float): Boolean {

        return true
    }

    override fun onSingleTapConfirmed(p0: MotionEvent): Boolean {
        Toast.makeText(this, "Boop", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onDoubleTap(p0: MotionEvent): Boolean {

        return true
    }

    override fun onDoubleTapEvent(p0: MotionEvent): Boolean {
        Toast.makeText(this, "Pat pat", Toast.LENGTH_SHORT).show()
        return true
    }
}