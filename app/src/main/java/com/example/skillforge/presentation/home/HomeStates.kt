package com.example.skillforge.presentation.home

import com.example.skillforge.domain.model.data_model.CategoryModel
import com.example.skillforge.domain.model.data_model.CourseModel
import com.example.skillforge.domain.model.data_model.LessonModel

data class HomeStates(
    val isLoading: Boolean = false,
    val categoryList: List<CategoryModel> = emptyList(),
    val lessonList: List<LessonModel> = emptyList(),
    val courseList: List<CourseModel> = emptyList()
)