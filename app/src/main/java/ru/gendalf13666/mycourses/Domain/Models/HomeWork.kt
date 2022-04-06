package ru.gendalf13666.mycourses.Domain.Models

data class HomeWork(
    val id: Int,
    val title: String,
    val icon: String,
    val deadLine: String,
    val work: String,
    val tagIconOne: String,
    val tagIconTwo: String
)
