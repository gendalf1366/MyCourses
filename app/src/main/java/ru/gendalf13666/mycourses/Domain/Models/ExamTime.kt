package ru.gendalf13666.mycourses.Domain.Models

data class ExamTime(
    val dayFirst: String,
    val daySecond: String,
    val hourFirst: String,
    val hourSecond: String,
    val minuteFirst: String,
    val minuteSecond: String
) : Response
