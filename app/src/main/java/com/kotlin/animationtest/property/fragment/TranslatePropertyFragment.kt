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
class TranslatePropertyFragment : Fragment() {
    lateinit var mTranslateXAnimator: ObjectAnimator
    lateinit var mTranslateYAnimator: ObjectAnimator
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
            mTranslateXAnimator = ObjectAnimator.ofFloat(mPropertyIv, "translationX", 0f,100f,200f,300f)

            mTranslateYAnimator = ObjectAnimator.ofFloat(mPropertyIv, "translationY", 0f,100f)
            mTranslateYAnimator.repeatCount = -1
            mTranslateYAnimator.repeatMode = ObjectAnimator.REVERSE
            val set = AnimatorSet()
            set.playTogether(mTranslateXAnimator,mTranslateYAnimator)
            set.duration = 5000
            set.start()
        }
        mStopBtn.setOnClickListener {
            mTranslateXAnimator.cancel()
            mTranslateYAnimator.cancel()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mTranslateXAnimator.cancel()
        mTranslateYAnimator.cancel()
    }
}