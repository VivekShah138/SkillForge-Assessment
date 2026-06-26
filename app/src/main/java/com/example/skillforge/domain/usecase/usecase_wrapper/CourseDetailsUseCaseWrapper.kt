package com.example.skillforge.domain.usecase.usecase_wrapper

import com.example.skillforge.domain.usecase.remote.GetCategoriesRemoteUseCase
import com.example.skillforge.domain.usecase.local.GetCourseByIdUseCase
import com.example.skillforge.domain.usecase.local.GetCoursesFromCategoriesUseCase

data class CourseDetailsUseCaseWrapper(
    val getCategoriesRemoteUseCase: GetCategoriesRemoteUseCase,
    val getCoursesFromCategoriesUseCase: GetCoursesFromCategoriesUseCase,
    val getCourseByIdUseCase: GetCourseByIdUseCase
)
