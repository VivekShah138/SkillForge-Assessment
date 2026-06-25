package com.example.skillforge.domain.model

data class LessonModel(
    val title: String,
    val duration: String,
    val isFree: Boolean,
)

val dummyLessons = listOf(
    LessonModel("Welcome & Setup", "8 min", true),
    LessonModel("Variables & Null Safety", "15 min", true),
    LessonModel("Functions & Lambdas", "18 min", false)
)