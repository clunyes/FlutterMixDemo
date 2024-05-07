package com.zk.demozk.module.pathAnim

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.zk.demozk.R

/**
 * @author zhaokang
 * @date :2024/4/23
 * @description:
 */
class PathAnimView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {
    private var paintLineGreen: Paint = Paint()
    private var paintLineYellow: Paint = Paint()
     val powerLinePath = Path()

    init {
        setWillNotDraw(false)
        initView()

        paintLineGreen.isAntiAlias = true
        paintLineGreen.isDither = true
        paintLineGreen.color = ResourcesCompat.getColor(resources, R.color.color_home_storage_theme_t7, null)
        paintLineGreen.style = Paint.Style.STROKE
        paintLineGreen.strokeWidth = 2f

        paintLineYellow.isAntiAlias = true
        paintLineYellow.isDither = true
        paintLineYellow.color = ResourcesCompat.getColor(resources, R.color.color_home_storage_theme_t9, null)
        paintLineYellow.style = Paint.Style.STROKE
        paintLineYellow.strokeWidth = 2f
    }

    private fun initView() {

    }

    fun start() {
        postInvalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val rect = RectF(309f, 380f, 419f, 490f)
        powerLinePath.moveTo(419f, 281f)
        powerLinePath.lineTo(419f, 435f)
        powerLinePath.arcTo(rect, 0F, 90F)
        powerLinePath.lineTo(364f, 490f)
        powerLinePath.lineTo(220f, 490f)
        canvas?.drawPath(powerLinePath, paintLineGreen)


//        canvas?.drawRect(rect, paintLineYellow)
    }

}