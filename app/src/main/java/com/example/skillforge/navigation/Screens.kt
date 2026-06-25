package com.example.skillforge.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screens {
    data object Home: Screens
    data class CourseDetails(val courseId: String): Screens
    data class CourseLesson(val courseId: String,val lessonId: String): Screens
}