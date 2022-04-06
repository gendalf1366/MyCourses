package ru.gendalf13666.mycourses.Domain.Usecases

import ru.gendalf13666.mycourses.Domain.AppState
import ru.gendalf13666.mycourses.Domain.Models.Exam
import ru.gendalf13666.mycourses.Domain.Repository.Repository

class GetExamUseCase(private val repository: Repository) {
    suspend fun execute(): AppState<Exam> =
        repository.getExamDate()
}
