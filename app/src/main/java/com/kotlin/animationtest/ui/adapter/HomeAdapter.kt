package com.kotlin.animationtest.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kotlin.animationtest.R
/**
 * create by SunHao in 2021/5/27
 *
 * @Description : 主页adapter
 **/
class HomeAdapter:BaseQuickAdapter<String,BaseViewHolder>(R.layout.lay_home) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.mHomeText,item)
    }
}