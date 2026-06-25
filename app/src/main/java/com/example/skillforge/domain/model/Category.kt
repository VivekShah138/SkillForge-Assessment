package com.example.skillforge.domain.model

data class CategoryModel(
    val title: String,
    val courseCount: String
)

data class CourseModel(
    val level: String,
    val title: String,
    val author: String,
    val rating: String,
    val duration: String
)

val dummyCategories = listOf(
    CategoryModel("Android Development", "2 courses"),
    CategoryModel("Backend & APIs", "2 courses"),
    CategoryModel("UI/UX Design", "4 courses")
)

val dummyCourses = listOf(
    CourseModel(
        "BEGINNER",
        "Kotlin Fundamentals",
        "Aarav Sharma",
        "4.7",
        "6.5h"
    ),
    CourseModel(
        "INTERMEDIATE",
        "Jetpack Compose Essentials",
        "Meera Nair",
        "4.8",
        "9h"
    ),
    CourseModel(
        "BEGINNER",
        "Node.js from Scratch",
        "Sara Khan",
        "4.5",
        "7.5h"
    )
)