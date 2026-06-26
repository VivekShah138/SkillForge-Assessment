package com.example.skillforge.domain.usecase.local

import com.example.skillforge.domain.model.CategoryModel
import com.example.skillforge.domain.model.CourseModel

class GetCoursesFromCategoriesUseCase {

    operator fun invoke(categories: List<CategoryModel>): List<CourseModel> {
        return categories.flatMap { category ->
            category.courses
        }
    }
}