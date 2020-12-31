package com.example.hiltdependency.network

import com.example.hiltdependency.Utility.NetworkConstants
import com.example.hiltdependency.model.Genress
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(NetworkConstants.GENRES)
      fun getGenres(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Observable<Genress>
}