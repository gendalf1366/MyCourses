package ru.gendalf13666.mycourses.Ui.Home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.gendalf13666.mycourses.Domain.Models.Facultative
import ru.gendalf13666.mycourses.Domain.Models.Lesson
import ru.gendalf13666.mycourses.Domain.Models.Lessonable
import ru.gendalf13666.mycourses.R

class LessonAdapter(private val delegate: Delegate?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder?>() {

    interface Delegate {

        /**
         * Событие наступает при выборе
         * урока из списка.
         * @param lessonResponse Урок
         */
        fun onLessonItemPicked(lessonResponse: Lessonable)
    }

    private val data = ArrayList<Lessonable>()

    fun setItems(newList: ArrayList<Lessonable>) {
        val result = DiffUtil.calculateDiff(DiffUtilCallback(data, newList))
        result.dispatchUpdatesTo(this)
        data.clear()
        data.addAll(newList)
    }

    override fun getItemCount() = data.size

    override fun getItemViewType(position: Int): Int {
        when (data[position]) {
            is Lesson -> return LESSON
            is Facultative -> return FACULTATIVE
        }
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            LESSON -> {
                val root = LayoutInflater.from(parent.context).inflate(
                    R.layout.lesson_item,
                    parent,
                    false
                )
                LessonViewHolder(root)
            }
            FACULTATIVE -> {
                val root = LayoutInflater.from(parent.context).inflate(
                    R.layout.facultative_item,
                    parent,
                    false
                )
                FacultativeViewHolder(root)
            }
            else -> throw IllegalArgumentException(UNKNOWN_TYPE_ERROR)
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (holder) {
            is LessonViewHolder -> {
                (holder).bind(data[position] as Lesson, delegate)
            }
            is FacultativeViewHolder -> {
                (holder).bind(data[position] as Facultative, delegate)
            }
            else -> throw IllegalArgumentException(UNKNOWN_TYPE_ERROR)
        }

    inner class DiffUtilCallback(
        private var oldItems: ArrayList<Lessonable>,
        private var newItems: ArrayList<Lessonable>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldItems.size

        override fun getNewListSize(): Int = newItems.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            if (oldItems[oldItemPosition] is Lesson && newItems[newItemPosition] is Lesson) {
                (oldItems[oldItemPosition] as Lesson).id == (newItems[newItemPosition] as Lesson).id
            } else if (oldItems[oldItemPosition] is Facultative && newItems[newItemPosition] is Facultative) {
                (oldItems[oldItemPosition] as Facultative).id == (newItems[newItemPosition] as Facultative).id
            } else false

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            if (oldItems[oldItemPosition] is Lesson && newItems[newItemPosition] is Lesson) {
                (oldItems[oldItemPosition] as Lesson) == (newItems[newItemPosition] as Lesson)
            } else if (oldItems[oldItemPosition] is Facultative && newItems[newItemPosition] is Facultative) {
                (oldItems[oldItemPosition] as Facultative) == (newItems[newItemPosition] as Facultative)
            } else false
    }

    companion object {
        private const val LESSON = 0
        private const val FACULTATIVE = 1
        private const val UNKNOWN_TYPE_ERROR = "Unknown type"
    }
}
