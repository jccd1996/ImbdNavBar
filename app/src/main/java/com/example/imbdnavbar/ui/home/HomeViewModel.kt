package com.example.imbdnavbar.ui.home

import ImbdApi
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imbdnavbar.domain.model.Results
import kotlinx.coroutines.GlobalScope

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    private val _data = MutableLiveData<List<Results>>()

    val data: LiveData<List<Results>>
        get() = _data

    val moviesAPI = RetrofitHelper.getInstance().create(ImbdApi::class.java)

    suspend fun
            call() {
        val result = moviesAPI.getMovies()
        if (result != null){
            Log.d("Data: ", result.body().toString())
            _data.value = result.body()?.results
        }
    }
}