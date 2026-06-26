package com.example.skillforge.presentation.course_details

sealed interface CourseDetailsEvents {
    data class OnLessonClick(
        val lessonId: String,
        val courseId: String,
        val isFree: Boolean
    ) : CourseDetailsEvents

    data object OnClickRetry: CourseDetailsEvents
}