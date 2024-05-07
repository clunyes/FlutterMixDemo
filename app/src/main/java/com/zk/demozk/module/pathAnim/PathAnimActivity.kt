package com.zk.demozk.module.pathAnim

import android.animation.Animator
import android.animation.ValueAnimator
import android.graphics.PathMeasure
import android.os.Bundle
import android.os.Handler
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.LogUtils
import com.zk.demozk.databinding.ActivityPathBinding
import timber.log.Timber
import kotlin.math.atan2


/**
 * @author zhaokang
 * @date :2024/4/23
 * @description:
 */
class PathAnimActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPathBinding
    private var pathMeasure: PathMeasure? = null
    private val position = FloatArray(2)
    private val tan = FloatArray(2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPathBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pathAnimView.start()

        initListener()
    }

    private fun initListener() {
        binding.ivPower.viewTreeObserver.addOnGlobalLayoutListener(OnGlobalLayoutListener { // TODO Auto-generated method stub
            startAnim()
        })
    }

    private fun startAnim() {
        Handler().post(Runnable {
            val path = binding.pathAnimView.powerLinePath
            //pathMeasure用来计算显示坐标
            pathMeasure = PathMeasure(path, false)

            //属性动画加载
            //属性动画加载
            val valueAnimator = ValueAnimator.ofFloat(0f, pathMeasure!!.length)

            valueAnimator.duration = 10000
            //加入差值器
            valueAnimator.interpolator = LinearInterpolator()
            //添加监听
            //添加监听
            valueAnimator.addUpdateListener { animation -> //获取当前位置
                val value = animation.animatedValue as Float
                //boolean getPosTan(float distance, float[] pos, float[] tan) ：
                //传入一个距离distance(0<=distance<=getLength())，然后会计算当前距
                // 离的坐标点和切线，pos会自动填充上坐标
                pathMeasure!!.getPosTan(value, position, tan)
                val degrees = (atan2(tan[1].toDouble(), tan[0].toDouble()) * 180.0 / Math.PI).toFloat()
                Timber.d("degrees: $degrees")
                //设置旋转角度
//                binding.ivPower.rotation = -degrees
                //打印当前坐标
//                KLog.i(mCurrentPosition[0]+"    "+mCurrentPosition[1]);
                //设置视图坐标
                binding.ivPower.x = position[0] - binding.ivPower.width / 2
                binding.ivPower.y = position[1] - binding.ivPower.height / 2
            }
            valueAnimator.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                }

                override fun onAnimationEnd(animation: Animator) {
                    valueAnimator.start()
                }

                override fun onAnimationCancel(animation: Animator) {
                }

                override fun onAnimationRepeat(animation: Animator) {
                }

            })
            valueAnimator.start()
        })
    }
}