package com.kotlin.animationtest.animator.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.animationtest.R
import com.kotlin.animationtest.animator.adapter.AnimatorTabAdapter
import kotlinx.android.synthetic.main.acy_animator.*

class AnimatorAcy:AppCompatActivity() {
    private lateinit var mAdapter:AnimatorTabAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acy_animator)
        initView()
    }

    private fun initView() {
        mAdapter = AnimatorTabAdapter(supportFragmentManager)
        mAnimatorVp.apply {
            adapter = mAdapter
        }

        mAnimatorTL.setupWithViewPager(mAnimatorVp)
    }
}