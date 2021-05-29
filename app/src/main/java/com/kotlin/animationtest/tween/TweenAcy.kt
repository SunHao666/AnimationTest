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
            R.id.mAlphaBtn -> {         //透明度
                setImgAlpha()
            }
            R.id.mScaleBtn -> {          //缩放
                setImgScale()
            }
            R.id.mRotateBtn -> {         //旋转
//                setImgRotate()
                setRotateAnimation()
            }
            R.id.mTranslateBtn -> {      //位移
                setImgTranslate()
            }
            R.id.mStopAnimation -> {     //停止动画
                imageView.clearAnimation()
            }
        }
    }
    /*
    * fromDegrees 开始角度
    * toDegrees   结束角度
    */
    private fun setRotateAnimation(fromDegrees: Float = 0f, toDegrees: Float = 360f) {
        rotateAnimation = RotateAnimation(fromDegrees, toDegrees, 50f, 50f)
        rotateAnimation.duration = 2000

        rotateAnimation.apply {
            fillAfter = cb_keep.isChecked                   //动画在播放结束时是否保持最终的状态
            repeatCount = if (cb_loop.isChecked) {          //动画的重复次数
                0
            } else {
                -1
            }

            repeatMode = if (cb_reverse.isChecked) {        //动画的重复方式
                Animation.REVERSE                           //反转动画
            } else {
                Animation.RESTART                           //重新播放动画
            }

        }
        imageView.startAnimation(rotateAnimation)           //开始动画
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