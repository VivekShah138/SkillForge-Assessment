package com.example.skillforge.di


import android.content.Context
import com.example.skillforge.data.data_source.remote.CategoryApi
import com.example.skillforge.data.repository.network.NetworkMonitorImpl
import com.example.skillforge.data.repository.remote.CategoryRepositoryImpl
import com.example.skillforge.domain.repository.network.NetworkMonitor
import com.example.skillforge.domain.repository.remote.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    // Provide network monitor repository
    @Provides
    @Singleton
    fun provideNetworkMonitorRepository(@ApplicationContext context: Context): NetworkMonitor {
        return NetworkMonitorImpl(context = context)
    }
}