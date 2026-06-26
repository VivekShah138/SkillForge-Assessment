package com.example.skillforge.utils.events

import com.example.skillforge.domain.model.CourseModel
import com.example.skillforge.domain.model.SelectedLesson

sealed interface LessonUiEvents {
    data object Loading : LessonUiEvents
    data object Error : LessonUiEvents
    data object NoInternet : LessonUiEvents

    data class Success(
        val course: CourseModel,
        val selectedLesson: SelectedLesson
    ) : LessonUiEvents
}