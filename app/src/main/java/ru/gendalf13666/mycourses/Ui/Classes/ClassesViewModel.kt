package ru.gendalf13666.mycourses.Ui.Classes

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.gendalf13666.mycourses.Domain.AppState
import ru.gendalf13666.mycourses.Domain.Models.Response
import ru.gendalf13666.mycourses.Domain.Usecases.GetLessonUseCase
import ru.gendalf13666.mycourses.Ui.Base.BaseViewModel

class ClassesViewModel(
    private val lessonsLiveData: MutableLiveData<AppState<Response>> =
        MutableLiveData<AppState<Response>>(),
    private val getLessonUseCase: GetLessonUseCase,
) : BaseViewModel() {

    fun getLessonsLiveData() = lessonsLiveData

    fun getLessons(): Job =
        viewModelScopeCoroutine.launch {
            getLessonsLiveData().postValue(
                getLessonUseCase.execute()
            )
        }

    override fun handleError(throwable: Throwable) {}
}
