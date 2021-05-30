package com.kotlin.animationtest.animator.fragment

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kotlin.animationtest.R
import com.kotlin.animationtest.animator.wigets.SportView
import kotlinx.android.synthetic.main.fragment_progress.*

class ProgressFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_progress,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animator()
    }

    private fun animator() {
        val objectAnimator = ObjectAnimator.ofInt(sportView,"progress",0,20)
        objectAnimator.duration = 5000
        objectAnimator.start()
        val animatot = ObjectAnimator.ofFloat(mCatIv,"translationX",0f,200f)
        animatot.duration = 5000
        animatot.start()
    }
}