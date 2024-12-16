package com.example.simpleweatherapp.data.remote

import com.example.simpleweatherapp.domain.model.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI{

    @GET("/v1/current.json")
    suspend fun getWeather(
        @Query("key") apiKey : String,
        @Query("q") city : String
    ) : retrofit2.Response<WeatherModel>
}