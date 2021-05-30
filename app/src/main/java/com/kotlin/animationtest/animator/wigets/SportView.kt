package com.kotlin.animationtest.animator.wigets

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.kotlin.animationtest.R

/**
 * create by SunHao in 2021/5/29
 *
 * @Description : 自定义原型进度条
 **/
class SportView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private lateinit var textPaint:Paint
    private lateinit var bgPaint:Paint
    private lateinit var proPaint:Paint
    private lateinit var mRectF:RectF
    private var progress = 0
        set(value) {
            field = value
            invalidate()
        }

    init {
        initPaint()
    }

    private fun initPaint() {
        textPaint = Paint()
        textPaint.apply {
            isAntiAlias = true
            color = context.resources.getColor(R.color.white)
            textSize = 25f
        }
        bgPaint = Paint()
        bgPaint.apply {
            isAntiAlias = true              //抗锯齿
            strokeWidth = 10f               //外环大小
            isDither = true                 //防抖动
            strokeCap = Paint.Cap.ROUND     //设置圆角
            style = Paint.Style.STROKE      //只描边不填充
            color = Color.parseColor("#e4e4e4")
        }

        proPaint = Paint()
        proPaint.apply {
            isAntiAlias = true              //抗锯齿
            strokeWidth = 10f               //外环大小
            isDither = true                 //防抖动
            strokeCap = Paint.Cap.ROUND     //设置圆角
            style = Paint.Style.STROKE      //只描边不填充
            color = context.resources.getColor(R.color.teal_200)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //view时间宽高
        val mWidth = measuredWidth - paddingLeft - paddingRight
        val mHeight = measuredHeight - paddingTop - paddingBottom
        //圆环
        val left = bgPaint.strokeWidth
        val top = bgPaint.strokeWidth
        val right = mWidth + bgPaint.strokeWidth*2
        val bottom = mHeight+bgPaint.strokeWidth*2
        mRectF = RectF(left,top,right,bottom)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawArc(mRectF,0f,360f,false,bgPaint)
        canvas?.drawArc(mRectF,0f,360*progress/100f,false,proPaint)
    }
}


