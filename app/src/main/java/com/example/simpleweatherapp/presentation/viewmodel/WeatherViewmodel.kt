package com.example.simpleweatherapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleweatherapp.data.remote.Constants
import com.example.simpleweatherapp.domain.repository.WeatherRepository
import com.example.simpleweatherapp.presentation.ui.WeatherAction
import com.example.simpleweatherapp.presentation.ui.WeatherState
import com.example.simpleweatherapp.utils.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _weatherState = MutableLiveData<WeatherState>()
    val weatherState: LiveData<WeatherState> = _weatherState

    fun dispatch(action: WeatherAction) {
        when (action) {
            is WeatherAction.LoadWeather -> {
                getData(action.city)
            }
        }
    }

    private fun getData(city: String) {
        _weatherState.value = WeatherState.Loading
        viewModelScope.launch {
            val result = weatherRepository.getWeather(Constants.apiKey, city)
            _weatherState.value = when (result) {
                is NetworkResponse.Success -> WeatherState.Success(result.data)
                is NetworkResponse.Error -> WeatherState.Error(result.message)
                is NetworkResponse.Loading -> WeatherState.Loading
            }
        }
    }
}
