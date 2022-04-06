package ru.gendalf13666.mycourses.Ui.Home.adapter

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import ru.gendalf13666.mycourses.Domain.Models.Lesson
import ru.gendalf13666.mycourses.R
import ru.gendalf13666.mycourses.Utils.Extensions.click
import ru.gendalf13666.mycourses.Utils.Extensions.setStartDrawableCircleImageFromUri
import ru.gendalf13666.mycourses.databinding.LessonItemBinding

class LessonViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    private val viewBinding: LessonItemBinding by viewBinding()

    fun bind(lesson: Lesson, delegate: LessonAdapter.Delegate?) {
        with(viewBinding) {
            title.text = lesson.title
            root.click { delegate?.onLessonItemPicked(lesson) }
            openInArea.isVisible = lesson.useRemote
            scheduler.text = lesson.scheduler.toString()
            scheduler.setStartDrawableCircleImageFromUri(R.drawable.ic_time)
            Glide.with(icon)
                .load(lesson.icon)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(DrawableTransitionOptions().crossFade(DELAY))
                .placeholder(R.drawable.ic_no_image)
                .error(R.drawable.ic_no_image)
                .into(icon)
        }
    }

    companion object {
        const val DELAY = 800
    }
}
