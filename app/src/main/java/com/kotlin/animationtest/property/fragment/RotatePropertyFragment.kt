package com.kotlin.animationtest.property.fragment

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
class RotatePropertyFragment : Fragment() {
    lateinit var mRotationAnimator: ObjectAnimator
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
            mRotationAnimator = ObjectAnimator.ofFloat(mPropertyIv, "rotation", 0f,100f,200f,300f)
            mRotationAnimator.duration = 5000
            mRotationAnimator.repeatCount= 3
            mRotationAnimator.repeatMode = ObjectAnimator.REVERSE
            mRotationAnimator.start()

        }
        mStopBtn.setOnClickListener {
            mRotationAnimator.cancel()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mRotationAnimator.cancel()
    }
}