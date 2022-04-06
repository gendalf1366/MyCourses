package ru.gendalf13666.mycourses.Ui.Home

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import ru.gendalf13666.mycourses.Domain.AppState
import ru.gendalf13666.mycourses.Domain.Models.ExamTime
import ru.gendalf13666.mycourses.Domain.Models.Response
import ru.gendalf13666.mycourses.Domain.Usecases.GetExamUseCase
import ru.gendalf13666.mycourses.Domain.Usecases.GetHomeWorkUseCase
import ru.gendalf13666.mycourses.Domain.Usecases.GetLessonUseCase
import ru.gendalf13666.mycourses.Ui.Base.BaseViewModel
import ru.gendalf13666.mycourses.Utils.Extensions.dateBetween

class HomeViewModel(
    private val lessonsLiveData: MutableLiveData<AppState<Response>> =
        MutableLiveData<AppState<Response>>(),
    private val countdownLiveData: MutableLiveData<AppState<ExamTime>> =
        MutableLiveData<AppState<ExamTime>>(),
    private val getLessonUseCase: GetLessonUseCase,
    private val getHomeWorkUseCase: GetHomeWorkUseCase,
    private val getExamUseCase: GetExamUseCase
) : BaseViewModel() {

    fun getLessonsLiveData() = lessonsLiveData
    fun getCountDownLiveData() = countdownLiveData

    fun getData(): Job =
        viewModelScopeCoroutine.launch {
            getLessons().join()
            delay(DELAY)
            getHomeWork().join()
            delay(DELAY)
            getExam()
        }

    fun clear() {
        viewModelScopeCoroutine.cancel()
    }

    private fun countDown(dateExam: String): Job =
        viewModelScopeCoroutine.launch {
            while (true) {
                val result = dateBetween(dateExam)
                result?.let {
                    getCountDownLiveData().postValue(AppState.Success(it))
                }
                delay(EXAM_UPDATE_DELAY)
            }
        }

    private fun getLessons(): Job =
        viewModelScopeCoroutine.launch {
            getLessonsLiveData().postValue(
                getLessonUseCase.execute()
            )
        }

    private fun getHomeWork(): Job =
        viewModelScopeCoroutine.launch {
            getLessonsLiveData().postValue(
                getHomeWorkUseCase.execute()
            )
        }

    private fun getExam(): Job =
        viewModelScopeCoroutine.launch {
            this.coroutineContext.cancelChildren()
            val result = getExamUseCase.execute()
            if (result is AppState.Success) {
                countDown(result.data.date)
            }
        }

    override fun handleError(throwable: Throwable) {}

    companion object {
        private const val DELAY = 400L
        private const val EXAM_UPDATE_DELAY = 20000L
    }
}
