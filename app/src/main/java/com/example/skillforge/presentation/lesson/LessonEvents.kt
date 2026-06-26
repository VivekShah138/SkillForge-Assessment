package com.example.skillforge.presentation.lesson

import com.example.skillforge.domain.model.LessonTabs

sealed interface LessonEvents {
    data class OnClickLesson(
        val lessonId: String, val
        isFree: Boolean
    ) : LessonEvents

    data object OnClickRetry : LessonEvents
    data class OnClickTab(val tab: LessonTabs): LessonEvents
}