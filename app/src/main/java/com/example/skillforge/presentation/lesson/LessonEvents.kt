package com.example.skillforge.presentation.lesson

import com.example.skillforge.domain.model.data_model.SelectedLesson

sealed interface LessonEvents {
    data class OnClickLesson(
        val lessonId: String, val
        isFree: Boolean
    ) : LessonEvents
}