package com.example.skillforge.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screens {
    @Serializable
    data object Home: Screens
    @Serializable
    data class CourseDetails(val courseId: String): Screens
    @Serializable
    data class CourseLesson(val courseId: String,val lessonId: String): Screens
}