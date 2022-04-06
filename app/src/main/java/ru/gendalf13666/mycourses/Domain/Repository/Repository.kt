package ru.gendalf13666.mycourses.Domain.Repository

import ru.gendalf13666.mycourses.Domain.AppState
import ru.gendalf13666.mycourses.Domain.Models.Exam
import ru.gendalf13666.mycourses.Domain.Models.HomeWorks
import ru.gendalf13666.mycourses.Domain.Models.Lessons

interface Repository {
    suspend fun getLessons(): AppState<Lessons>
    suspend fun getHomeWork(): AppState<HomeWorks>
    suspend fun getExamDate(): AppState<Exam>
}
