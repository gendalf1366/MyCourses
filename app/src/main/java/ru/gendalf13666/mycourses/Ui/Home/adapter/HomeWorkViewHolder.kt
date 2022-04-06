package ru.gendalf13666.mycourses.Ui.Home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import ru.gendalf13666.mycourses.Domain.Models.HomeWork
import ru.gendalf13666.mycourses.R
import ru.gendalf13666.mycourses.Utils.Extensions.click
import ru.gendalf13666.mycourses.Utils.Extensions.dayLeftFrom
import ru.gendalf13666.mycourses.Utils.Extensions.setData
import ru.gendalf13666.mycourses.databinding.HomeWorkItemBinding

class HomeWorkViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    private val viewBinding: HomeWorkItemBinding by viewBinding()

    fun bind(homeWork: HomeWork, delegate: HomeWorkAdapter.Delegate?) {
        with(viewBinding) {
            title.text = homeWork.title
            root.click { delegate?.onHomeWorkItemPicked(homeWork) }
            work.text = homeWork.work
            deadLine.setData(dayLeftFrom(homeWork.deadLine))

            Glide.with(icon)
                .load(homeWork.icon)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(DrawableTransitionOptions().crossFade(DELAY))
                .placeholder(R.drawable.ic_no_image)
                .error(R.drawable.ic_no_image)
                .into(icon)

            Glide.with(iconOne)
                .load(homeWork.tagIconOne)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(DrawableTransitionOptions().crossFade(DELAY))
                .placeholder(R.drawable.ic_no_image)
                .error(R.drawable.ic_no_image)
                .into(iconOne)

            Glide.with(iconTwo)
                .load(homeWork.tagIconTwo)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transition(DrawableTransitionOptions().crossFade(DELAY))
                .placeholder(R.drawable.ic_no_image)
                .error(R.drawable.ic_no_image)
                .into(iconTwo)
        }
    }

    companion object {
        const val DELAY = 800
    }
}
