package com.kotlin.animationtest.widgets

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.AnimationDrawable
import android.view.Gravity
import android.view.WindowManager
import android.widget.ImageView
import androidx.core.app.DialogCompat
import com.kotlin.animationtest.R
import com.kotlin.animationtest.R.id.mAnimationIv

/**
 * create by SunHao in 2021/5/27
 *
 * @Description : 自定第loading
 **/
class LoadingDialog(context: Context, themeResId: Int) : Dialog(context, themeResId) {

    companion object {
        private lateinit var loadingDialog: LoadingDialog
        private lateinit var animationDrawable: AnimationDrawable
        fun create(context: Context): LoadingDialog {
            loadingDialog = LoadingDialog(context, R.style.LightProgressDialog)
            loadingDialog.apply {
                setContentView(R.layout.view_loading)           //自定义布局
                setCanceledOnTouchOutside(true)
                setCancelable(true)
            }

            val attributes = loadingDialog.window?.attributes
            attributes?.gravity = Gravity.CENTER     //window 位置
            attributes?.dimAmount = 0.4f            //背景透明度
            loadingDialog.window?.attributes = attributes
            val mAnimationIv = loadingDialog.findViewById<ImageView>(mAnimationIv)
            animationDrawable = mAnimationIv.background as AnimationDrawable
            return loadingDialog
        }
    }

    override fun show() {
        super.show()
        animationDrawable.start()
    }

    override fun dismiss() {
        super.dismiss()
        animationDrawable.stop()
    }

}