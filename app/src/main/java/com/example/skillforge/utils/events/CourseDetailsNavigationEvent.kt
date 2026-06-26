package com.example.skillforge.utils.events

sealed interface CourseDetailsNavigationEvent {
    data object OnFailure : CourseDetailsNavigationEvent
    data class OnSuccess(
        val lessonId: String,
        val courseId: String
    ) : CourseDetailsNavigationEvent
}