package com.example.skillforge.domain.usecase.usecase_wrapper

import com.example.skillforge.domain.usecase.remote.GetCategoriesRemoteUseCase
import com.example.skillforge.domain.usecase.remote.GetCourseByIdUseCase
import com.example.skillforge.domain.usecase.remote.GetCoursesFromCategoriesUseCase
import com.example.skillforge.domain.usecase.remote.GetSelectedLessonUseCase

data class LessonScreenUseCaseWrapper(
    val getCategoriesRemoteUseCase: GetCategoriesRemoteUseCase,
    val getCoursesFromCategoriesUseCase: GetCoursesFromCategoriesUseCase,
    val getCourseByIdUseCase: GetCourseByIdUseCase,
    val getSelectedLessonUseCase: GetSelectedLessonUseCase
)
