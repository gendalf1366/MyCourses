package ru.gendalf13666.mycourses.Ui.Base.CustomView

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.card.MaterialCardView

class SquareCardView(context: Context, attrs: AttributeSet) : MaterialCardView(context, attrs) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMeasure: Int = heightMeasureSpec
        super.onMeasure(widthMeasure, heightMeasureSpec)
    }
}
