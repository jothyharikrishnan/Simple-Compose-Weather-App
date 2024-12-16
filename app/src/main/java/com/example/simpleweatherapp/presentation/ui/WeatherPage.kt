package com.example.simpleweatherapp.presentation.ui

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.simpleweatherapp.presentation.viewmodel.WeatherViewModel

@Composable
fun WeatherPage(viewModel: WeatherViewModel = hiltViewModel()) {
    var city by remember { mutableStateOf("") }
    val weatherState by viewModel.weatherState.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar(city) { newCity ->
            city = newCity
            viewModel.dispatch(WeatherAction.LoadWeather(city))
        }

        when (val state = weatherState) {
            is WeatherState.Error -> Text(text = state.message)
            WeatherState.Loading -> CircularProgressIndicator()
            is WeatherState.Success -> WeatherDetails(data = state.data)
            else -> Text(text = "Search For Weather Data.")
        }
    }
}

@Composable
fun SearchBar(city: String, onSearch: (String) -> Unit) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        OutlinedTextField(
            modifier = Modifier.weight(1f),
            value = city,
            onValueChange = { onSearch(it) },
            label = { Text(text = "Search for any location") }
        )
        IconButton(
            onClick = {
                Log.d("WeatherData : ", "IconButton")
                keyboardController?.hide()
                onSearch(city)
            }
        ) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search Location")
        }
    }
}
