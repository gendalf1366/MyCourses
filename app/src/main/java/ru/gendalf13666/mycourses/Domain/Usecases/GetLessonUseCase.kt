package ru.gendalf13666.mycourses.Domain.Usecases

import ru.gendalf13666.mycourses.Domain.AppState
import ru.gendalf13666.mycourses.Domain.Models.Lessons
import ru.gendalf13666.mycourses.Domain.Repository.Repository

class GetLessonUseCase(private val repository: Repository) {
    suspend fun execute(): AppState<Lessons> =
        repository.getLessons()
}
