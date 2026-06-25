package com.example.skillforge.domain.model

import androidx.compose.ui.graphics.Color

data class CategoryModel(
    val title: String,
    val courseCount: String,
    val iconColor: Color
)

data class CourseModel(
    val level: String,
    val title: String,
    val author: String,
    val rating: String,
    val duration: String,
    val imageUrl: String
)

val dummyCategories = listOf(
    CategoryModel("Android Development", "2 courses", Color(0XFF2dd4bf)),
    CategoryModel("Backend & APIs", "2 courses", Color(0XFFFBBF24)),
    CategoryModel("UI/UX Design", "4 courses", Color(0XFF34d399))
)

val dummyCourses = listOf(
    CourseModel(
        "BEGINNER",
        "Kotlin Fundamentals",
        "Aarav Sharma",
        "4.7",
        "6.5h",
        imageUrl = "https://placehold.co/600x360/0f1720/fbbf24/png?text=Figma+for+Developers"
    ),
    CourseModel(
        "INTERMEDIATE",
        "Jetpack Compose Essentials",
        "Meera Nair",
        "4.8",
        "9h",
        imageUrl = "https://placehold.co/600x360/0f1720/fbbf24/png?text=Figma+for+Developers"
    ),
    CourseModel(
        "BEGINNER",
        "Node.js from Scratch",
        "Sara Khan",
        "4.5",
        "7.5h",
        imageUrl = "https://placehold.co/600x360/0f1720/fbbf24/png?text=Figma+for+Developers"
    )
)