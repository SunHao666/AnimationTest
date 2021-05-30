package com.kotlin.animationtest.property.fragment

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kotlin.animationtest.R
import kotlinx.android.synthetic.main.fragment_property_alpha.*

/**
 * create by SunHao in 2021/5/30
 *
 * @Description : 自定义属性Scale
 **/
class ScalePropertyFragment : Fragment() {
    lateinit var mScaleXAnimator: ObjectAnimator
    lateinit var mScaleYAnimator: ObjectAnimator
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_property_alpha, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        mStartBtn.setOnClickListener {
            mScaleXAnimator = ObjectAnimator.ofFloat(mPropertyIv, "scaleX", 1.0f,0.3f)

            mScaleYAnimator = ObjectAnimator.ofFloat(mPropertyIv, "scaleY", 1.0f,0.3f)
            mScaleYAnimator.repeatCount = -1
            mScaleYAnimator.repeatMode = ObjectAnimator.REVERSE
            val set = AnimatorSet()
            set.playTogether(mScaleXAnimator,mScaleYAnimator)
            set.duration = 5000
            set.start()
        }
        mStopBtn.setOnClickListener {
            mScaleXAnimator.cancel()
            mScaleYAnimator.cancel()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mScaleXAnimator.cancel()
        mScaleYAnimator.cancel()
    }
}