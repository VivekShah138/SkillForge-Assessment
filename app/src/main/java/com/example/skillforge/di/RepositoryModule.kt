package com.example.skillforge.di


import com.example.skillforge.data.data_source.remote.CategoryApi
import com.example.skillforge.data.repository.remote.CategoryRepositoryImpl
import com.example.skillforge.domain.repository.remote.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCategoryRemoteRepository(categoryApi: CategoryApi): CategoryRepository{
        return CategoryRepositoryImpl(
            categoryApi = categoryApi
        )
    }
}