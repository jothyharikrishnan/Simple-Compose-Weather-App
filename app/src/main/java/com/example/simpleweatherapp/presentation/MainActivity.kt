package com.example.simpleweatherapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.simpleweatherapp.presentation.theme.SimpleWeatherAppTheme
import com.example.simpleweatherapp.presentation.ui.WeatherPage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleWeatherAppTheme {
                WeatherPage()
            }
        }
    }
}

