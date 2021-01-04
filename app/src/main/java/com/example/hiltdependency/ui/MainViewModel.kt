package com.example.hiltdependency.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hiltdependency.model.Genress
import com.example.hiltdependency.usecase.DataUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel @ViewModelInject constructor(private val useCase: DataUseCase): ViewModel() {
    private val genres =MutableLiveData<Genress>()
    val _genres : LiveData<Genress> = genres
    private val compositeDisposable = CompositeDisposable()
    fun getGenres(){
        compositeDisposable.add(
                useCase.getRepositoryGenres()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            genres.postValue(it)
                            Log.d("bbbbb",it.toString())
                        },{
                            Log.d("bbbbb",it.message.toString())
                        })
        )
    }

}