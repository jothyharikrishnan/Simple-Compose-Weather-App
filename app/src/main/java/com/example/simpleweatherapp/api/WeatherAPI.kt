package com.example.simpleweatherapp.api

import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI{

    @GET("/v1/current.json")
    suspend fun getWeather(
        @Query("key") apiKey : String,
        @Query("q") city : String
    ) : retrofit2.Response<WeatherModel>
}