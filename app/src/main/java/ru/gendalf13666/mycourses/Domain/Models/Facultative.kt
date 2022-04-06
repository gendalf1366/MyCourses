package ru.gendalf13666.mycourses.Domain.Models

data class Facultative(
    val id: Int,
    val title: String,
    val icon: String,
    val scheduler: Schedulers,
    val teacher: String,
    val tagIconOne: String,
    val tagIconTwo: String,
    val tagIconThree: String,
    val description: String,
    val isTop: Boolean = false
) : Lessonable
