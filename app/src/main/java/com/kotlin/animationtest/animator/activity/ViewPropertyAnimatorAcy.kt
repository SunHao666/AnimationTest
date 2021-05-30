package com.kotlin.animationtest.animator.activity

import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateOvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.animationtest.R
import kotlinx.android.synthetic.main.acy_view_property.*

class ViewPropertyAnimatorAcy: AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acy_view_property)
        initListener()
        initAnimator()
    }

    private fun initListener() {
        mAlphaBtn.setOnClickListener(this)
        mScaleBtn.setOnClickListener(this)
        mTranslateBtn.setOnClickListener(this)
        mRotateBtn.setOnClickListener(this)
    }

    private fun initAnimator() {

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.mAlphaBtn ->{
                animatorIv.animate().alpha(1f)
            }

            R.id.mScaleBtn ->{
                animatorIv.animate().scaleX(2f)
                animatorIv.animate().scaleY(2f)
            }
            R.id.mTranslateBtn ->{
                animatorIv.animate().translationX(400f)
                    .setDuration(3000)
                    .setInterpolator(AnticipateOvershootInterpolator())
            }
            R.id.mRotateBtn ->{
                animatorIv.animate().setDuration(300)
                animatorIv.animate().rotation(360f)
            }

        }
    }
}