package com.example.gestures

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat

// this app has various gestures doing different things, mostly popping up different toast messages
// initialized out here so they can be used by multiple classes

lateinit var iv: ImageView
var scale = 1f

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {


    var sgDetector: ScaleGestureDetector? = null
    var gDetector: GestureDetectorCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // for scaling the image with a pinch
        iv = findViewById(R.id.imgPupper)
        sgDetector = ScaleGestureDetector(this,ScaleListener())

        // for detecting other gestures
        this.gDetector = GestureDetectorCompat(this,this)
        gDetector?.setOnDoubleTapListener(this)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            this.gDetector?.onTouchEvent(event)
            this.sgDetector?.onTouchEvent(event)
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
        Toast.makeText(this, "Pet", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onLongPress(p0: MotionEvent) {

    }

    override fun onFling(p0: MotionEvent?, p1: MotionEvent, p2: Float, p3: Float): Boolean {
        Toast.makeText(this, "Scritch", Toast.LENGTH_SHORT).show()
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
        Toast.makeText(this, "Pat", Toast.LENGTH_SHORT).show()
        return true
    }

    // controls how much the image scales based on the pinch
    class ScaleListener: ScaleGestureDetector.SimpleOnScaleGestureListener(){

        override fun onScale(detector: ScaleGestureDetector): Boolean {
            scale *= detector.scaleFactor
            scale = Math.max(0.1f,Math.min(scale,5.0f))
            iv.scaleX = scale
            iv.scaleY = scale

            return true
        }

    }
}