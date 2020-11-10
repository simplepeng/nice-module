package me.simple.nm

import android.graphics.*
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.blankj.utilcode.util.SizeUtils

class CoverDrawable(
    private var view: ImageView,
    private var color: Int = Color.parseColor("#D0D0D0"),
    private var radius: Int = SizeUtils.dp2px(8f)
) : Drawable() {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mImageView = view

    init {
        mPaint.color = color
    }

    override fun draw(canvas: Canvas) {
        val rectF = RectF(0f, 0f, mImageView.width.toFloat(), mImageView.height.toFloat())
        canvas.drawRoundRect(
            rectF,
            radius.toFloat(), radius.toFloat(),
            mPaint
        )
    }

    override fun setAlpha(alpha: Int) {
        mPaint.alpha = alpha
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        mPaint.colorFilter = colorFilter
    }

    override fun getIntrinsicHeight(): Int {
        return mImageView.measuredHeight
    }

    override fun getIntrinsicWidth(): Int {
        return mImageView.measuredWidth
    }
}