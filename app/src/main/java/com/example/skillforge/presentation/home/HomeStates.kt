package com.example.skillforge.presentation.home

import com.example.skillforge.domain.model.CategoryModel
import com.example.skillforge.domain.model.CourseModel
import com.example.skillforge.domain.model.LessonModel
import com.example.skillforge.utils.events.UiEvents

data class HomeStates(
    val uiEvents: UiEvents = UiEvents.NormalScreen,
    val categoryList: List<CategoryModel> = emptyList(),
    val lessonList: List<LessonModel> = emptyList(),
    val courseList: List<CourseModel> = emptyList(),
)