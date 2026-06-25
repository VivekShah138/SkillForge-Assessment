package com.example.skillforge.domain.model

import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt

//
//import androidx.compose.ui.graphics.Color
//
//data class CategoryModel(
//    val title: String,
//    val courseCount: String,
//    val iconColor: Color
//)
//
//data class CourseModel(
//    val level: String,
//    val title: String,
//    val author: String,
//    val rating: String,
//    val duration: String,
//    val imageUrl: String,
//    val tags: List<String>
//)
//
//val dummyCategories = listOf(
//    CategoryModel("Android Development", "2 courses", Color(0XFF2dd4bf)),
//    CategoryModel("Backend & APIs", "2 courses", Color(0XFFFBBF24)),
//    CategoryModel("UI/UX Design", "4 courses", Color(0XFF34d399))
//)
//
//
//val dummyCourses = listOf(
//    CourseModel(
//        level = "BEGINNER",
//        title = "Kotlin Fundamentals",
//        author = "Aarav Sharma",
//        rating = "4.7",
//        duration = "6.5h",
//        imageUrl = "https://placehold.co/600x360/0f1720/fbbf24/png?text=Kotlin",
//        tags = listOf("Kotlin", "Basics", "JVM")
//    ),
//    CourseModel(
//        level = "INTERMEDIATE",
//        title = "Jetpack Compose Essentials",
//        author = "Meera Nair",
//        rating = "4.8",
//        duration = "9h",
//        imageUrl = "https://placehold.co/600x360/0f1720/fbbf24/png?text=Compose",
//        tags = listOf("Compose", "Android", "UI")
//    ),
//    CourseModel(
//        level = "BEGINNER",
//        title = "Node.js from Scratch",
//        author = "Sara Khan",
//        rating = "4.5",
//        duration = "7.5h",
//        imageUrl = "https://placehold.co/600x360/0f1720/fbbf24/png?text=Node",
//        tags = listOf("Node.js", "Backend", "JavaScript")
//    )
//)



// -------------------- CATEGORY --------------------

data class CategoryModel(
    val id: String,
    val name: String,
    val description: String,
    val iconColor: String,
    val courseCount: Int,
    val courses: List<CourseModel>
)

// -------------------- COURSE --------------------

data class CourseModel(
    val id: String,
    val title: String,
    val subtitle: String,
    val thumbnailUrl: String,
    val level: String,
    val durationHours: Double,
    val rating: Double,
    val studentsEnrolled: Int,
    val language: String,
    val lastUpdated: String,
    val tags: List<String>,
    val instructor: InstructorModel,
    val description: String,
    val lessons: List<LessonModel>
)

// -------------------- INSTRUCTOR --------------------

data class InstructorModel(
    val id: String,
    val name: String,
    val title: String,
    val avatarUrl: String,
    val bio: String
)

// -------------------- LESSON --------------------

data class LessonModel(
    val id: String,
    val title: String,
    val durationMinutes: Int,
    val isFree: Boolean,
    val videoUrl: String,
    val content: String
)

fun String.toColor(): Color {
    return Color(this.toColorInt())
}

val dummyCategories = listOf(
    CategoryModel(
        id = "cat_1",
        name = "Android Development",
        description = "Build Android apps",
        iconColor = "#2dd4bf",
        courseCount = 2,
        courses = emptyList()
    ),
    CategoryModel(
        id = "cat_2",
        name = "Backend & APIs",
        description = "Learn backend systems",
        iconColor = "#fbbf24",
        courseCount = 2,
        courses = emptyList()
    ),
    CategoryModel(
        id = "cat_3",
        name = "UI/UX Design",
        description = "Design modern UI",
        iconColor = "#34d399",
        courseCount = 4,
        courses = emptyList()
    )
)



val dummyCourses = listOf(
    CourseModel(
        id = "course_1",
        title = "Kotlin Fundamentals",
        subtitle = "Learn Kotlin from scratch",
        thumbnailUrl = "https://placehold.co/600x360/0f1720/fbbf24/png?text=Kotlin",
        level = "BEGINNER",
        durationHours = 6.5,
        rating = 4.7,
        studentsEnrolled = 1200,
        language = "English",
        lastUpdated = "2026-01-10",
        tags = listOf("Kotlin", "Basics", "JVM"),
        instructor = InstructorModel(
            id = "inst_1",
            name = "Aarav Sharma",
            title = "Android Developer",
            avatarUrl = "https://placehold.co/200x200",
            bio = "Android dev with Kotlin experience"
        ),
        description = "Learn Kotlin step by step",
        lessons = emptyList()
    ),

    CourseModel(
        id = "course_2",
        title = "Jetpack Compose Essentials",
        subtitle = "Modern Android UI",
        thumbnailUrl = "https://placehold.co/600x360/0f1720/fbbf24/png?text=Compose",
        level = "INTERMEDIATE",
        durationHours = 9.0,
        rating = 4.8,
        studentsEnrolled = 2000,
        language = "English",
        lastUpdated = "2026-02-15",
        tags = listOf("Compose", "UI", "Android"),
        instructor = InstructorModel(
            id = "inst_2",
            name = "Meera Nair",
            title = "UI Engineer",
            avatarUrl = "https://placehold.co/200x200",
            bio = "Compose expert"
        ),
        description = "Learn Jetpack Compose",
        lessons = emptyList()
    ),

    CourseModel(
        id = "course_3",
        title = "Node.js Basics",
        subtitle = "Backend with JavaScript",
        thumbnailUrl = "https://placehold.co/600x360/0f1720/fbbf24/png?text=Node",
        level = "BEGINNER",
        durationHours = 7.5,
        rating = 4.5,
        studentsEnrolled = 900,
        language = "English",
        lastUpdated = "2026-01-20",
        tags = listOf("Node.js", "Backend", "API"),
        instructor = InstructorModel(
            id = "inst_3",
            name = "Sara Khan",
            title = "Backend Developer",
            avatarUrl = "https://placehold.co/200x200",
            bio = "Node.js backend dev"
        ),
        description = "Learn backend development",
        lessons = emptyList()
    )
)

val dummyLessons = listOf(
    LessonModel(
        id = "l1",
        title = "Introduction to Course",
        durationMinutes = 5,
        isFree = true,
        videoUrl = "https://example.com/video1.mp4",
        content = "Welcome to the course. Overview of what you'll learn."
    ),

    LessonModel(
        id = "l2",
        title = "Setup & Installation",
        durationMinutes = 12,
        isFree = true,
        videoUrl = "https://example.com/video2.mp4",
        content = "Setting up development environment step by step."
    ),

    LessonModel(
        id = "l3",
        title = "Core Concepts",
        durationMinutes = 18,
        isFree = false,
        videoUrl = "https://example.com/video3.mp4",
        content = "Understanding the core concepts in detail."
    ),

    LessonModel(
        id = "l4",
        title = "Practical Example",
        durationMinutes = 22,
        isFree = false,
        videoUrl = "https://example.com/video4.mp4",
        content = "Hands-on implementation of what you've learned."
    ),

    LessonModel(
        id = "l5",
        title = "Advanced Topics",
        durationMinutes = 30,
        isFree = false,
        videoUrl = "https://example.com/video5.mp4",
        content = "Deep dive into advanced concepts."
    )
)