package com.example.hiltdependency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hiltdependency.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : MainViewModel

    //kcckjffnsdkjv


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel=ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel._genres.observe(this, Observer {
            Log.d("vvvvvv",it.genres.toString())
        })
        viewModel.getGenres()
    }
}