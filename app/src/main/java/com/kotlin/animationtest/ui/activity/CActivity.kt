package com.kotlin.animationtest.ui.activity

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.startActivity

class CActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val textView = TextView(this)

        setContentView(textView)
        textView.text = "这个界面C"
        textView.layoutParams.apply {
            width = WindowManager.LayoutParams.MATCH_PARENT
            height = WindowManager.LayoutParams.MATCH_PARENT
        }
        textView.gravity = Gravity.CENTER
        textView.setOnClickListener {
            startActivity<AActivity>()
        }
    }
}