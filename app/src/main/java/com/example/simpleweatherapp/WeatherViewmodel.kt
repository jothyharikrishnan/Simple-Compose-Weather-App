package com.example.simpleweatherapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleweatherapp.api.Constants
import com.example.simpleweatherapp.api.NetworkResponse
import com.example.simpleweatherapp.api.RetrofitInstance
import com.example.simpleweatherapp.api.WeatherModel
import kotlinx.coroutines.launch

class WeatherViewmodel:ViewModel() {

    private val weatherAPI = RetrofitInstance.weatherAPI

    private val _weatherResult = MutableLiveData<NetworkResponse<WeatherModel>>()
     val weatherResult :LiveData<NetworkResponse<WeatherModel>> = _weatherResult


    fun getData(city  :String){
        _weatherResult.value = NetworkResponse.Loading
    viewModelScope.launch {
      try {
          val response = weatherAPI.getWeather(Constants.apiKey,city)
          if (response.isSuccessful){
              response.body()?.let {
                  _weatherResult.value = NetworkResponse.Success(it)
              }
              Log.d("WeatherData: Success",response.body().toString())
          }else{
              _weatherResult.value = NetworkResponse.Error("Failed to load data")
              Log.d("WeatherData: Error ", response.message())
          }
      }catch (e:Exception){
          _weatherResult.value = NetworkResponse.Error("${e.message}")
      }
    }
    }
}