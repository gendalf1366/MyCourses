package ru.gendalf13666.mycourses.Domain.Models

data class Schedulers(
    val start: String,
    val end: String
) {
    override fun toString(): String = "$start - $end"
}
