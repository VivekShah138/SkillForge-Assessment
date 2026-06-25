package com.example.skillforge.presentation.lesson

import com.example.skillforge.domain.model.data_model.CourseModel
import com.example.skillforge.domain.model.data_model.LessonModel
import com.example.skillforge.domain.model.data_model.SelectedLesson

data class LessonStates(
    val isLoading: Boolean = false,
    val selectedCourse: CourseModel? = null,
    val selectedLesson: SelectedLesson? = null
)