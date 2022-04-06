package ru.gendalf13666.mycourses.Ui.Base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

abstract class BaseViewModel : ViewModel() {
    protected val viewModelScopeCoroutine = CoroutineScope(
        Dispatchers.IO +
            SupervisorJob() +
            CoroutineExceptionHandler { _, throwable ->
                handleError(throwable)
            }
    )

    abstract fun handleError(throwable: Throwable)

    override fun onCleared() {
        super.onCleared()
        viewModelScopeCoroutine
            .coroutineContext
            .cancel()
    }
}
