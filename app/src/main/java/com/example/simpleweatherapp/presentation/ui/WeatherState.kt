package com.example.simpleweatherapp.presentation.ui

import com.example.simpleweatherapp.domain.model.WeatherModel

sealed class WeatherState {
    object Loading : WeatherState()
    data class Success(val data: WeatherModel) : WeatherState()
    data class Error(val message: String) : WeatherState()
}
