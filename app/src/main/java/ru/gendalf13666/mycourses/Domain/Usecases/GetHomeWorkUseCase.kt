package ru.gendalf13666.mycourses.Domain.Usecases

import ru.gendalf13666.mycourses.Domain.AppState
import ru.gendalf13666.mycourses.Domain.Models.HomeWorks
import ru.gendalf13666.mycourses.Domain.Repository.Repository

class GetHomeWorkUseCase(private val repository: Repository) {
    suspend fun execute(): AppState<HomeWorks> =
        repository.getHomeWork()
}
