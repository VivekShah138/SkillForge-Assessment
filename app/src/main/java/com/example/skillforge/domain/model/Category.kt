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
    val imageUrl: String,
    val tags: List<String>
)

val dummyCategories = listOf(
    CategoryModel("Android Development", "2 courses", Color(0XFF2dd4bf)),
    CategoryModel("Backend & APIs", "2 courses", Color(0XFFFBBF24)),
    CategoryModel("UI/UX Design", "4 courses", Color(0XFF34d399))
)


val dummyCourses = listOf(
    CourseModel(
        level = "BEGINNER",
        title = "Kotlin Fundamentals",
        author = "Aarav Sharma",
        rating = "4.7",
        duration = "6.5h",
        imageUrl = "https://placehold.co/600x360/0f1720/fbbf24/png?text=Kotlin",
        tags = listOf("Kotlin", "Basics", "JVM")
    ),
    CourseModel(
        level = "INTERMEDIATE",
        title = "Jetpack Compose Essentials",
        author = "Meera Nair",
        rating = "4.8",
        duration = "9h",
        imageUrl = "https://placehold.co/600x360/0f1720/fbbf24/png?text=Compose",
        tags = listOf("Compose", "Android", "UI")
    ),
    CourseModel(
        level = "BEGINNER",
        title = "Node.js from Scratch",
        author = "Sara Khan",
        rating = "4.5",
        duration = "7.5h",
        imageUrl = "https://placehold.co/600x360/0f1720/fbbf24/png?text=Node",
        tags = listOf("Node.js", "Backend", "JavaScript")
    )
)