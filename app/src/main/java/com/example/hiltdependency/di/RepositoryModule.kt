package com.example.hiltdependency.di

import com.example.hiltdependency.network.ApiService
import com.example.hiltdependency.reposiories.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object RepositoryModule {
    @Provides
    fun providesDataRepo(apiService: ApiService) : DataRepository{
        return DataRepository(apiService)
    }
}