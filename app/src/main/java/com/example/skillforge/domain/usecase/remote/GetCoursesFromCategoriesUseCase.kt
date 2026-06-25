package com.example.skillforge.domain.usecase.remote

import com.example.skillforge.domain.model.data_model.CategoryModel
import com.example.skillforge.domain.model.data_model.CourseModel

class GetCoursesFromCategoriesUseCase {

    operator fun invoke(categories: List<CategoryModel>): List<CourseModel> {
        return categories.flatMap { category ->
            category.courses
        }
    }
}