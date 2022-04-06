package ru.gendalf13666.mycourses.Utils.Extensions

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.transition.Transition
import com.google.android.material.snackbar.Snackbar
import ru.gendalf13666.mycourses.R
import kotlin.math.roundToInt

fun View.showSnakeBar(text: String, length: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, text, length).show()
}

fun View.click(click: () -> Unit) = setOnClickListener { click() }

fun View.longClick(longClick: () -> Boolean) = setOnLongClickListener { longClick() }

fun Fragment.arguments(vararg arguments: Pair<String, Any>): Fragment {
    this.arguments = bundleOf(*arguments)
    return this
}

@Suppress("IMPLICIT_CAST_TO_ANY")
fun TextView.setStartDrawableCircleImageFromUri(uri: Int, placeholder: Int = 0) {
    Glide.with(context)
        .load(uri)
        .placeholder(placeholder)
        .apply(
            RequestOptions
                .circleCropTransform()
                .override(20.dp(this.context))
        )
        .into(object : CustomViewTarget<TextView, Drawable>(this) {

            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                view.setCompoundDrawable(resource, null, null, null)
            }

            override fun onResourceCleared(placeholder: Drawable?) {
                view.setCompoundDrawable(placeholder, null, null, null)
            }

            override fun onLoadFailed(errorDrawable: Drawable?) {
                view.setCompoundDrawable(errorDrawable, null, null, null)
            }
        })
}

fun TextView.setCompoundDrawable(
    left: Drawable? = null,
    top: Drawable? = null,
    right: Drawable? = null,
    bottom: Drawable? = null
) {
    setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom)
}

fun Int.dp(context: Context): Int =
    TypedValue
        .applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            context.resources.displayMetrics
        )
        .roundToInt()

fun View.setPointBackground(isTop: Boolean) {
    if (isTop) {
        this.setBackgroundResource(R.drawable.circle_big_background)
    } else {
        this.setBackgroundResource(R.drawable.circle_small_background)
    }
}

fun TextView.setData(countDay: Long) {
    if (countDay < MIN_LEFT_DAY) {
        this.setTextColor(Color.parseColor(COLOR_RED))
        this.setStartDrawableCircleImageFromUri(R.drawable.ic_time_red)
    } else {
        this.setTextColor(Color.parseColor(COLOR_GRAY))
        this.setStartDrawableCircleImageFromUri(R.drawable.ic_time)
    }
    this.text = String.format(LEFT_DAY, countDay)
}

const val LEFT_DAY = "%s дней осталось"
const val COLOR_RED = "#8d3c4f"
const val COLOR_GRAY = "#515257"
const val MIN_LEFT_DAY = 3
