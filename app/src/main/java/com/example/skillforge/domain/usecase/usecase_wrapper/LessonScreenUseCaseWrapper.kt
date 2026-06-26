package com.example.skillforge.domain.usecase.usecase_wrapper

import com.example.skillforge.domain.usecase.remote.GetCategoriesRemoteUseCase
import com.example.skillforge.domain.usecase.local.GetCourseByIdUseCase
import com.example.skillforge.domain.usecase.local.GetCoursesFromCategoriesUseCase
import com.example.skillforge.domain.usecase.local.GetSelectedLessonUseCase
import com.example.skillforge.domain.usecase.local.NetworkMonitorLocalUseCase

data class LessonScreenUseCaseWrapper(
    val getCategoriesRemoteUseCase: GetCategoriesRemoteUseCase,
    val getCoursesFromCategoriesUseCase: GetCoursesFromCategoriesUseCase,
    val getCourseByIdUseCase: GetCourseByIdUseCase,
    val getSelectedLessonUseCase: GetSelectedLessonUseCase,
    val networkMonitorLocalUseCase: NetworkMonitorLocalUseCase
)
