package com.example.simpleweatherapp.data.repository

import com.example.simpleweatherapp.utils.NetworkResponse
import com.example.simpleweatherapp.domain.model.WeatherModel
import com.example.simpleweatherapp.data.remote.WeatherAPI
import com.example.simpleweatherapp.domain.mapper.toDomainModel
import com.example.simpleweatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherAPI
) : WeatherRepository {

    override suspend fun getWeather(apiKey: String, city: String): NetworkResponse<WeatherModel> {
        return try {
            val response = api.getWeather(apiKey, city)
            if (response.isSuccessful) {
                response.body()?.let {
                    NetworkResponse.Success(it.toDomainModel())
                } ?: NetworkResponse.Error("Unknown Error")
            } else {
                NetworkResponse.Error(response.message())
            }
        } catch (e: Exception) {
            NetworkResponse.Error(e.message ?: "Unknown Error")
        }
    }
}
