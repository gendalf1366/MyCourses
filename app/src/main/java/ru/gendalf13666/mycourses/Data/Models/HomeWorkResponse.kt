package ru.gendalf13666.mycourses.Data.Models

data class HomeWorkResponse(
    val id: Int,
    val title: String,
    val icon: String,
    val deadLine: String,
    val work: String,
    val tagIconOne: String,
    val tagIconTwo: String
)
