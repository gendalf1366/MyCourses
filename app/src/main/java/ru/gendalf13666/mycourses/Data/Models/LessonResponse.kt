package ru.gendalf13666.mycourses.Data.Models

import ru.gendalf13666.mycourses.Domain.Models.Lessonable
import ru.gendalf13666.mycourses.Domain.Models.Schedulers

data class LessonResponse(
    val id: Int,
    val title: String,
    val icon: String,
    val scheduler: Schedulers,
    val teacher: String,
    val useRemote: Boolean = false,
    val isTop: Boolean = false
) : Lessonable
