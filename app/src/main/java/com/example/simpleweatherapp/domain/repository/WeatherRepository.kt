package com.example.simpleweatherapp.domain.repository


import com.example.simpleweatherapp.utils.NetworkResponse
import com.example.simpleweatherapp.domain.model.WeatherModel

interface WeatherRepository {
    suspend fun getWeather(apiKey: String, city: String): NetworkResponse<WeatherModel>
}
