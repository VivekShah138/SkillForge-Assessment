package com.example.skillforge.utils.mapper

import com.example.skillforge.domain.model.CategoryModel
import com.example.skillforge.domain.dto_response.CategoryResponse

fun CategoryResponse.toCategoryModel(): CategoryModel {
    return CategoryModel(
        id = id,
        name = name,
        description = description,
        iconColor = iconColor,
        courseCount = courseCount.toIntOrNull() ?: 0,
        courses = courses.map { it.toCourseModel() }
    )
}