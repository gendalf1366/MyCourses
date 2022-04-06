package ru.gendalf13666.mycourses.Ui.Base.CustomView

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView

class VerticalTextView(context: Context?, attrs: AttributeSet?) :
    AppCompatTextView(context!!, attrs) {
    private var topDown = false
    private var textPaint = paint
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(measuredHeight, measuredWidth)
    }

    override fun onDraw(canvas: Canvas) {
        textPaint.color = currentTextColor
        textPaint.drawableState = drawableState
        canvas.save()
        if (topDown) {
            canvas.translate(width.toFloat(), ZERO_VALUE)
            canvas.rotate(ANGLE)
        } else {
            canvas.translate(ZERO_VALUE, height.toFloat())
            canvas.rotate(-ANGLE)
        }
        canvas.translate(compoundPaddingLeft.toFloat(), extendedPaddingTop.toFloat())
        layout.draw(canvas)
        canvas.restore()
    }

    init {
        val gravity = gravity
        topDown = if (Gravity.isVertical(gravity) &&
            gravity and Gravity.VERTICAL_GRAVITY_MASK == Gravity.BOTTOM
        ) {
            setGravity(gravity and Gravity.HORIZONTAL_GRAVITY_MASK or Gravity.TOP)
            false
        } else {
            true
        }
    }

    companion object {
        private const val ANGLE = 90F
        private const val ZERO_VALUE = 0F
    }
}
