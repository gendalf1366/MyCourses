package ru.gendalf13666.mycourses.Ui.Classes

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.gendalf13666.mycourses.Domain.AppState
import ru.gendalf13666.mycourses.Domain.Models.Lessonable
import ru.gendalf13666.mycourses.Domain.Models.Lessons
import ru.gendalf13666.mycourses.R
import ru.gendalf13666.mycourses.Ui.Base.BaseFragment
import ru.gendalf13666.mycourses.Ui.Classes.Adapter.Adapter
import ru.gendalf13666.mycourses.Utils.Extensions.getCurrentDate
import ru.gendalf13666.mycourses.Utils.Extensions.upperMonthInString
import ru.gendalf13666.mycourses.databinding.FragmentClassesBinding

class ClassesFragment :
    BaseFragment<FragmentClassesBinding>(R.layout.fragment_classes),
    Adapter.Delegate {

    private val viewModel: ClassesViewModel by viewModel()
    private val adapter by lazy { Adapter(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerSetting()
        viewModel.getLessons()
        setCurrentDate()
    }

    private fun setCurrentDate() {
        val dateString = getCurrentDate()
        viewBinding.date.text = String
            .format(CURRENT_DATE_STRING_TEMPLATE, upperMonthInString(dateString))
    }

    private fun initRecyclerSetting() {
        viewBinding.rvClasses.also { recycler ->
            recycler.adapter = adapter
            recycler.setHasFixedSize(true)
        }
    }

    override fun initListeners() {}

    override fun initObservers() {
        viewModel.getLessonsLiveData()
            .observe(viewLifecycleOwner) { res -> renderData(result = res) }
    }

    override fun renderSuccess(result: AppState.Success<*>) {
        when (val res = result.data) {
            is Lessons -> {
                adapter.setItems(res.data as ArrayList<Lessonable>)
            }
        }
    }

    override fun showLoading(isShow: Boolean) {}

    override fun showError(throwable: Throwable) {}

    override fun onLessonItemPicked(lessonResponse: Lessonable) {}

    override fun onRunSkype() {
        try {
            val skype = Intent(ACTION_INTENT_STRING)
            skype.data = Uri.parse(SKYPE_URI_STRING)
            activity?.startActivity(skype)
        } catch (e: ActivityNotFoundException) {
        }
    }

    companion object {
        const val CURRENT_DATE_STRING_TEMPLATE = "Сегодня, %s"
        const val ACTION_INTENT_STRING = "android.intent.action.VIEW"
        const val SKYPE_URI_STRING = "skype:"
    }
}
