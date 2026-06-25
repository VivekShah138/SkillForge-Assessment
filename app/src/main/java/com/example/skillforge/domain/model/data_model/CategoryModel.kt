package com.example.skillforge.domain.model.data_model

data class CategoryModel(
    val id: String,
    val name: String,
    val description: String,
    val iconColor: String,
    val courseCount: Int,
    val courses: List<CourseModel>
)

