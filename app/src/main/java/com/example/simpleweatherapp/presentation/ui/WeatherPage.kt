package com.example.simpleweatherapp.presentation.ui

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.CloudOff
import androidx.compose.material.icons.outlined.ImageSearch
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.simpleweatherapp.presentation.viewmodel.WeatherViewModel

@Composable
fun WeatherPage(viewModel: WeatherViewModel = hiltViewModel()) {
    var city by remember { mutableStateOf("") }
    val weatherState by viewModel.weatherState.observeAsState()
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar(city,keyboardController) { newCity ->
            city = newCity
            viewModel.fetchData(WeatherAction.LoadWeather(city))

        }

        when (val state = weatherState) {
            is WeatherState.Error -> {
                Log.d("SearchBar : ", "Error : ${state.message}")
                WeatherResponseStatus(message = "Weather data could not be fetched. Please enter a valid location.",
                    imageVector = Icons.Outlined.CloudOff)
            }
            WeatherState.Loading -> CircularProgressIndicator()
            is WeatherState.Success -> {
                WeatherDetails(data = state.data)
                keyboardController?.hide()
                Log.d("SearchBar : ", "Success : ${state.data}")
            }
            else -> WeatherResponseStatus(message = "Please search for your location to get the weather information.",
                imageVector =Icons.Outlined.ImageSearch )
        }
    }
}

@Composable
fun SearchBar(
    city: String,
    keyboardController: SoftwareKeyboardController?,
    onSearch: (String) -> Unit,
              ) {

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

@Composable
fun WeatherResponseStatus(
    message : String,
    imageVector: ImageVector
){
    Column(
        modifier = Modifier.fillMaxSize().padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = message,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(10.dp),)

        Icon(imageVector = imageVector, contentDescription = "Search Data",
            modifier = Modifier.size(100.dp) )
    }
}
