package com.example.skillforge.presentation.course_details

import com.example.skillforge.domain.model.CourseModel
import com.example.skillforge.utils.events.CourseDetailsUiEvents
import com.example.skillforge.utils.events.HomeScreenUiEvents

data class CourseDetailsStates(
    val uiEvents: CourseDetailsUiEvents = CourseDetailsUiEvents.Loading
)