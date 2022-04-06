package ru.gendalf13666.mycourses.Data.Repository.datasource

import ru.gendalf13666.mycourses.Data.Models.FacultativeResponse
import ru.gendalf13666.mycourses.Data.Models.LessonResponse
import ru.gendalf13666.mycourses.Data.mockGetExam
import ru.gendalf13666.mycourses.Data.mockGetHomWork
import ru.gendalf13666.mycourses.Data.mockGetLessons
import ru.gendalf13666.mycourses.Data.tags
import ru.gendalf13666.mycourses.Domain.AppState
import ru.gendalf13666.mycourses.Domain.Models.*

class MockDataSourceImpl : DataSource {
    override suspend fun getLessons(): AppState<Lessons> {
        val result = mockGetLessons()
        return AppState.Success(
            Lessons(
                data = result.map {
                    when (it) {
                        is FacultativeResponse -> {
                            Facultative(
                                id = it.id,
                                title = it.title,
                                icon = it.icon,
                                scheduler = it.scheduler,
                                teacher = it.teacher,
                                tagIconOne = it.tagIconOne,
                                tagIconTwo = it.tagIconTwo,
                                tagIconThree = it.tagIconThree,
                                description = it.description,
                                isTop = it.isTop
                            )
                        }
                        is LessonResponse -> {
                            Lesson(
                                id = it.id,
                                title = it.title,
                                icon = it.icon,
                                scheduler = it.scheduler,
                                useRemote = it.useRemote,
                                teacher = it.teacher,
                                isTop = it.isTop
                            )
                        }
                        else -> {
                            throw Exception("Unknown type")
                        }
                    }
                }
            )
        )
    }

    override suspend fun getHomeWork(): AppState<HomeWorks> {
        val result = mockGetHomWork()
        return AppState.Success(
            HomeWorks(
                data = result.map {
                    HomeWork(
                        id = it.id,
                        title = it.title,
                        icon = it.icon,
                        deadLine = it.deadLine,
                        work = it.work,
                        tagIconOne = tags.first(),
                        tagIconTwo = tags.last()
                    )
                }
            )
        )
    }

    override suspend fun getExamDate(): AppState<Exam> {
        val result = mockGetExam()
        return AppState.Success(
            Exam(
                date = result.date
            )
        )
    }
}
