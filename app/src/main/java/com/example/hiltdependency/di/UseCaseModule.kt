package com.example.hiltdependency.di

import com.example.hiltdependency.reposiories.DataRepository
import com.example.hiltdependency.usecase.DataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object UseCaseModule {
    @Provides
    fun providesUseCase(dataRepository: DataRepository): DataUseCase{
        return DataUseCase(dataRepository)
    }
}