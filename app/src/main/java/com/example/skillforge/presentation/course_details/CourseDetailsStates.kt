package com.example.skillforge.presentation.course_details

import com.example.skillforge.domain.model.CourseModel

data class CourseDetailsStates(
    val isLoading: Boolean = false,
    val selectedCourse: CourseModel? = null
)