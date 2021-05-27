package com.kotlin.animationtest.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.animationtest.R
import com.kotlin.animationtest.widgets.LoadingDialog
import kotlinx.android.synthetic.main.acy_frame.*

class FrameAnimationAcy : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acy_frame)
        initView()
        initEvent()
    }

    private fun initView() {

    }

    private fun initEvent() {
        mLoadingBtn.setOnClickListener {
            LoadingDialog.create(this).show()
        }
    }
}