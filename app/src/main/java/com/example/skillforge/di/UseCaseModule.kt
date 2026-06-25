package com.example.skillforge.di

import com.example.skillforge.domain.repository.remote.CategoryRepository
import com.example.skillforge.domain.usecase.remote.GetCategoriesRemoteUseCase
import com.example.skillforge.domain.usecase.remote.GetCoursesFromCategoriesUseCase
import com.example.skillforge.domain.usecase.usecase_wrapper.HomeScreenUseCaseWrapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideHomeScreenUseCase(
        categoryRepository: CategoryRepository
    ): HomeScreenUseCaseWrapper {
        return HomeScreenUseCaseWrapper(
            getCategoriesRemoteUseCase = GetCategoriesRemoteUseCase(
                categoryRepository = categoryRepository,
            ),
            getCoursesFromCategoriesUseCase = GetCoursesFromCategoriesUseCase()
        )
    }
}