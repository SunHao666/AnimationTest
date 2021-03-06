package com.kotlin.animationtest.tween

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.animationtest.R
import kotlinx.android.synthetic.main.acy_tween.*

class TweenAcy : AppCompatActivity(), View.OnClickListener {

    private lateinit var rotateAnimation: RotateAnimation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acy_tween)
        initClick()
    }

    private fun initClick() {
        mAlphaBtn.setOnClickListener(this)
        mScaleBtn.setOnClickListener(this)
        mRotateBtn.setOnClickListener(this)
        mTranslateBtn.setOnClickListener(this)
        mStopAnimation.setOnClickListener(this)
        mFromDegreesSb.max = 360
        mFromDegreesSb.progress = 30

        mToDegreesSb.max = 360
        mToDegreesSb.progress = 90
        mFromDegreesSb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                setRotateAnimation(fromDegrees = progress.toFloat())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        mToDegreesSb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                setRotateAnimation(mFromDegreesSb.progress.toFloat(), progress.toFloat())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

    private fun setImgAlpha() {
        val loadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha)
        imageView.startAnimation(loadAnimation)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.mAlphaBtn -> {         //?????????
                setImgAlpha()
            }
            R.id.mScaleBtn -> {          //??????
                setImgScale()
            }
            R.id.mRotateBtn -> {         //??????
//                setImgRotate()
                setRotateAnimation()
            }
            R.id.mTranslateBtn -> {      //??????
                setImgTranslate()
            }
            R.id.mStopAnimation -> {     //????????????
                imageView.clearAnimation()
            }
        }
    }
    /*
    * fromDegrees ????????????
    * toDegrees   ????????????
    */
    private fun setRotateAnimation(fromDegrees: Float = 0f, toDegrees: Float = 360f) {
        rotateAnimation = RotateAnimation(fromDegrees, toDegrees, 50f, 50f)
        rotateAnimation.duration = 2000

        rotateAnimation.apply {
            fillAfter = cb_keep.isChecked                   //???????????????????????????????????????????????????
            repeatCount = if (cb_loop.isChecked) {          //?????????????????????
                0
            } else {
                -1
            }

            repeatMode = if (cb_reverse.isChecked) {        //?????????????????????
                Animation.REVERSE                           //????????????
            } else {
                Animation.RESTART                           //??????????????????
            }

        }
        imageView.startAnimation(rotateAnimation)           //????????????
    }

    private fun setImgTranslate() {
        val loadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_tranlate)
        imageView.startAnimation(loadAnimation)
    }

    private fun setImgRotate() {
        val loadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate)
        imageView.startAnimation(loadAnimation)
    }

    private fun setImgScale() {
        val loadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_scale)
        imageView.startAnimation(loadAnimation)

        mStopAnimation.startAnimation(loadAnimation)
    }
}