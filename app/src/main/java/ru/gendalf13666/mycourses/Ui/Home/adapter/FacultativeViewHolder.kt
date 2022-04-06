package ru.gendalf13666.mycourses.Ui.Home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import ru.gendalf13666.mycourses.Domain.Models.Facultative
import ru.gendalf13666.mycourses.R
import ru.gendalf13666.mycourses.Utils.Extensions.click
import ru.gendalf13666.mycourses.databinding.FacultativeItemBinding

class FacultativeViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    private val viewBinding: FacultativeItemBinding by viewBinding()

    fun bind(lesson: Facultative, delegate: LessonAdapter.Delegate?) {
        with(viewBinding) {
            title.text = lesson.title
            teacher.text = String
                .format(TEACHER_STRING_TEMPLATE, lesson.teacher)
            Glide.with(icon)
                .load(lesson.icon)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(DrawableTransitionOptions().crossFade(DELAY))
                .placeholder(R.drawable.ic_no_image)
                .error(R.drawable.ic_no_image)
                .into(icon)
            root.click { delegate?.onLessonItemPicked(lesson) }
        }
    }

    companion object {
        const val TEACHER_STRING_TEMPLATE = "Учитель: %s"
        const val DELAY = 800
    }
}
