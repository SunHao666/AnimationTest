package com.kotlin.animationtest.animator.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kotlin.animationtest.R
import kotlinx.android.synthetic.main.fragment_alpha.*

class ScaleFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_alpha,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAlphaStartBtn.setOnClickListener {
            mCatIv.animate().apply {
                duration = 2000
                scaleX(2f)
                scaleY( 2f)
            }
        }

        mAlphaStopBtn.setOnClickListener {
            mCatIv.animate().apply {
                duration = 2000
                scaleX(-2f)
                scaleY( -2f)
            }
        }

    }
}