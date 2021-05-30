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
 * @Description : 自定义属性alpha
 **/
class AlphaPropertyFragment : Fragment() {
    lateinit var objectAnimator: ObjectAnimator
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
            objectAnimator = ObjectAnimator.ofFloat(mPropertyIv, "alpha", 1.0f, 0.1f)
            objectAnimator.apply {
                duration = 5000
                repeatCount = -1
                repeatMode = ObjectAnimator.REVERSE
            }
            objectAnimator.start()
        }
        mStopBtn.setOnClickListener {
            objectAnimator.cancel()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        objectAnimator.cancel()
    }
}