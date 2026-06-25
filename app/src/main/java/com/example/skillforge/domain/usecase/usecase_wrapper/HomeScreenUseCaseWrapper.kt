package com.example.skillforge.domain.usecase.usecase_wrapper

import com.example.skillforge.domain.usecase.remote.GetCategoriesRemoteUseCase

data class HomeScreenUseCaseWrapper(
    val getCategoriesRemoteUseCase: GetCategoriesRemoteUseCase
)
