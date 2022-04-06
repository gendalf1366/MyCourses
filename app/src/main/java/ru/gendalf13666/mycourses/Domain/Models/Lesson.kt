package ru.gendalf13666.mycourses.Domain.Models

data class Lesson(
    val id: Int,
    val title: String,
    val icon: String,
    val scheduler: Schedulers,
    val teacher: String,
    val useRemote: Boolean = false,
    val isTop: Boolean = false
) : Lessonable
