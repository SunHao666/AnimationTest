package com.kotlin.animationtest.animator.fragment

import android.animation.TimeInterpolator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import com.kotlin.animationtest.R
import kotlinx.android.synthetic.main.fragment_alpha.*
import kotlinx.android.synthetic.main.fragment_alpha.mCatIv
import kotlinx.android.synthetic.main.fragment_translate.*

class TranslateFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_translate,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mStartBtn.setOnClickListener {
            mCatIv.animate().apply {
                duration = 2000
                translationX(200f)
            }
        }

        mStopBtn.setOnClickListener {
            mCatIv.animate().apply {
                duration = 2000
                translationX(0f)
                translationY( 0f)
            }
        }

        mStart1Btn.setOnClickListener {
            mCatIv1.animate().apply {
                duration = 3000
                interpolator = AccelerateDecelerateInterpolator()
                translationX(200f)
            }
        }


    }
}