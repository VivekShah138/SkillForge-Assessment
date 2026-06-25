package com.example.skillforge.utils

import com.example.skillforge.domain.model.data_model.CategoryModel
import com.example.skillforge.domain.model.data_model.CourseModel
import com.example.skillforge.domain.model.data_model.InstructorModel
import com.example.skillforge.domain.model.data_model.LessonModel


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
        description = "Start from zero and learn Kotlin's syntax, null safety, collections, and functions. By the end you'll be comfortable reading and writing idiomatic Kotlin.",
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