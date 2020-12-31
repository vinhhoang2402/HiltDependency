package com.example.hiltdependency.usecase

import com.example.hiltdependency.model.Geneses
import com.example.hiltdependency.reposiories.DataRepository
import io.reactivex.Observable
import javax.inject.Inject

class DataUseCase
@Inject constructor(private val repository: DataRepository) {
    fun getRepositoryGenres(): Observable<Geneses> {
        return repository.getGenres()
    }
}