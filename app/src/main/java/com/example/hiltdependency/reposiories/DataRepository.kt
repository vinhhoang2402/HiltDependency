package com.example.hiltdependency.reposiories

import android.util.Log
import com.example.hiltdependency.Utility.NetworkConstants
import com.example.hiltdependency.model.Genress
import com.example.hiltdependency.network.ApiService
import io.reactivex.Observable
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiService: ApiService) {
      fun getGenres():Observable<Genress> {
          Log.d("dddddd", "ssssss")
          return apiService.getGenres(NetworkConstants.API_KEY, NetworkConstants.LANGUAGE)
      }
}