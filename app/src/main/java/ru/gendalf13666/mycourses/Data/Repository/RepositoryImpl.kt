package ru.gendalf13666.mycourses.Data.Repository

import ru.gendalf13666.mycourses.Data.Repository.datasource.DataSource
import ru.gendalf13666.mycourses.Domain.AppState
import ru.gendalf13666.mycourses.Domain.Models.Exam
import ru.gendalf13666.mycourses.Domain.Models.HomeWorks
import ru.gendalf13666.mycourses.Domain.Models.Lessons
import ru.gendalf13666.mycourses.Domain.Repository.Repository

class RepositoryImpl(private val dataSource: DataSource) : Repository {
    override suspend fun getLessons(): AppState<Lessons> =
        dataSource.getLessons()

    override suspend fun getHomeWork(): AppState<HomeWorks> =
        dataSource.getHomeWork()

    override suspend fun getExamDate(): AppState<Exam> =
        dataSource.getExamDate()
}
