package com.example.simpleweatherapp.domain.usecase


import com.example.simpleweatherapp.domain.repository.WeatherRepository
import com.example.simpleweatherapp.domain.model.WeatherModel
import com.example.simpleweatherapp.utils.NetworkResponse
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    suspend operator fun invoke(apiKey: String, city: String): NetworkResponse<WeatherModel> {
        return repository.getWeather(apiKey, city)
    }
}
