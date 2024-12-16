package com.example.simpleweatherapp.presentation.ui


sealed class WeatherAction {
    data class LoadWeather(val city: String) : WeatherAction()
}
