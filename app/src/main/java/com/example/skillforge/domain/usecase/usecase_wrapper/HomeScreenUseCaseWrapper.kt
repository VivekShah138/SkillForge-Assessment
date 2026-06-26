package com.example.skillforge.domain.usecase.usecase_wrapper

import com.example.skillforge.domain.usecase.remote.GetCategoriesRemoteUseCase
import com.example.skillforge.domain.usecase.local.GetCoursesFromCategoriesUseCase
import com.example.skillforge.domain.usecase.local.NetworkMonitorLocalUseCase

data class HomeScreenUseCaseWrapper(
    val getCategoriesRemoteUseCase: GetCategoriesRemoteUseCase,
    val getCoursesFromCategoriesUseCase: GetCoursesFromCategoriesUseCase,
    val networkMonitorLocalUseCase: NetworkMonitorLocalUseCase

)
