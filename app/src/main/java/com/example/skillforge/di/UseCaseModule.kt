package com.example.skillforge.di

import com.example.skillforge.domain.repository.network.NetworkMonitor
import com.example.skillforge.domain.repository.remote.CategoryRepository
import com.example.skillforge.domain.usecase.remote.GetCategoriesRemoteUseCase
import com.example.skillforge.domain.usecase.local.GetCourseByIdUseCase
import com.example.skillforge.domain.usecase.local.GetCoursesFromCategoriesUseCase
import com.example.skillforge.domain.usecase.local.GetSelectedLessonUseCase
import com.example.skillforge.domain.usecase.local.NetworkMonitorLocalUseCase
import com.example.skillforge.domain.usecase.usecase_wrapper.CourseDetailsUseCaseWrapper
import com.example.skillforge.domain.usecase.usecase_wrapper.HomeScreenUseCaseWrapper
import com.example.skillforge.domain.usecase.usecase_wrapper.LessonScreenUseCaseWrapper
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
        categoryRepository: CategoryRepository,
        networkMonitor: NetworkMonitor
    ): HomeScreenUseCaseWrapper {
        return HomeScreenUseCaseWrapper(
            getCategoriesRemoteUseCase = GetCategoriesRemoteUseCase(
                categoryRepository = categoryRepository,
            ),
            getCoursesFromCategoriesUseCase = GetCoursesFromCategoriesUseCase(),
            networkMonitorLocalUseCase = NetworkMonitorLocalUseCase(
                networkMonitor = networkMonitor
            )
        )
    }

    @Provides
    @Singleton
    fun provideCourseDetailsUseCase(
        categoryRepository: CategoryRepository,
        networkMonitor: NetworkMonitor
    ): CourseDetailsUseCaseWrapper {
        return CourseDetailsUseCaseWrapper(
            getCategoriesRemoteUseCase = GetCategoriesRemoteUseCase(
                categoryRepository = categoryRepository,
            ),
            getCoursesFromCategoriesUseCase = GetCoursesFromCategoriesUseCase(),
            getCourseByIdUseCase = GetCourseByIdUseCase(),
            networkMonitorLocalUseCase = NetworkMonitorLocalUseCase(
                networkMonitor = networkMonitor
            )
        )
    }


    @Provides
    @Singleton
    fun provideLessonsUseCase(
        categoryRepository: CategoryRepository,
        networkMonitor: NetworkMonitor
    ): LessonScreenUseCaseWrapper {
        return LessonScreenUseCaseWrapper(
            getCategoriesRemoteUseCase = GetCategoriesRemoteUseCase(
                categoryRepository = categoryRepository,
            ),
            getCoursesFromCategoriesUseCase = GetCoursesFromCategoriesUseCase(),
            getCourseByIdUseCase = GetCourseByIdUseCase(),
            getSelectedLessonUseCase = GetSelectedLessonUseCase(),
            networkMonitorLocalUseCase = NetworkMonitorLocalUseCase(
                networkMonitor = networkMonitor
            )
        )
    }
}