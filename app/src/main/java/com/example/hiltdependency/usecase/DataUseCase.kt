package com.example.hiltdependency.usecase

import android.util.Log
import com.example.hiltdependency.model.Genress
import com.example.hiltdependency.reposiories.DataRepository
import io.reactivex.Observable
import javax.inject.Inject

class DataUseCase
@Inject constructor(private val repository: DataRepository) {
     fun getRepositoryGenres(): Observable<Genress> {
         Log.d("ddddd","lllllll")
        return repository.getGenres()
    }
}