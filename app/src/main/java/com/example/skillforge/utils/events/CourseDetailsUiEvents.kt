package com.example.skillforge.utils.events

import com.example.skillforge.domain.model.CourseModel

sealed interface CourseDetailsUiEvents {
    data object Loading : CourseDetailsUiEvents
    data class Success(val course: CourseModel) : CourseDetailsUiEvents
    data object Error : CourseDetailsUiEvents
    data object NoInternet :CourseDetailsUiEvents
}