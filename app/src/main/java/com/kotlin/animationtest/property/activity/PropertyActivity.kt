package com.kotlin.animationtest.property.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.animationtest.R
import com.kotlin.animationtest.animator.adapter.AnimatorTabAdapter
import com.kotlin.animationtest.property.adapter.PropertyAabAdapter
import kotlinx.android.synthetic.main.acy_animator.*

/**
 * create by SunHao in 2021/5/30
 *
 * @Description : 自定义属性动画
 **/
class PropertyActivity:AppCompatActivity() {
    private lateinit var mAdapter:PropertyAabAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acy_animator)
        initView()
    }

    private fun initView() {
        mAdapter = PropertyAabAdapter(supportFragmentManager)
        mAnimatorVp.apply {
            adapter = mAdapter
        }

        mAnimatorTL.setupWithViewPager(mAnimatorVp)
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}