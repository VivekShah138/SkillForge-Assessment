package com.example.skillforge.domain.usecase.usecase_wrapper

import com.example.skillforge.domain.usecase.remote.GetCategoriesRemoteUseCase
import com.example.skillforge.domain.usecase.remote.GetCourseByIdUseCase
import com.example.skillforge.domain.usecase.remote.GetCoursesFromCategoriesUseCase

data class CourseDetailsUseCaseWrapper(
    val getCategoriesRemoteUseCase: GetCategoriesRemoteUseCase,
    val getCoursesFromCategoriesUseCase: GetCoursesFromCategoriesUseCase,
    val getCourseByIdUseCase: GetCourseByIdUseCase
)
