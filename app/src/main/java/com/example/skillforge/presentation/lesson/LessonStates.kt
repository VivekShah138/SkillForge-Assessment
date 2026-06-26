package com.example.skillforge.presentation.lesson

import com.example.skillforge.domain.model.CourseModel
import com.example.skillforge.domain.model.SelectedLesson

data class LessonStates(
    val isLoading: Boolean = false,
    val selectedCourse: CourseModel? = null,
    val selectedLesson: SelectedLesson? = null
)