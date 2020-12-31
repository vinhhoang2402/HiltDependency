package com.example.hiltdependency.di

import com.example.hiltdependency.Utility.NetworkConstants
import com.example.hiltdependency.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {
    @Provides
    fun providerBaseUrl():String{
        return NetworkConstants.BASE_URL
    }

    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor{
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor
    }

    @Provides
    fun providesOkHttpClient(logger : HttpLoggingInterceptor): OkHttpClient{
        return OkHttpClient.Builder().addInterceptor(logger).build()
    }

    @Provides
    fun providesConvectorFactory(): Converter.Factory{
        return GsonConverterFactory.create()
    }

    @Provides
    fun providesRxJava(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    fun providesRetrofit(base_url: String,okHttpClient: OkHttpClient,
                                 gSonConvert:Converter.Factory, rxJava: RxJava2CallAdapterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(base_url)
            .client(okHttpClient)
            .addConverterFactory(gSonConvert)
            .addCallAdapterFactory(rxJava)
            .build()
    }

    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return  retrofit.create(ApiService::class.java)
    }
}