package com.example.skillforge.presentation.lesson

sealed interface LessonEvents {
    data class OnClickLesson(
        val lessonId: String, val
        isFree: Boolean
    ) : LessonEvents
}