package com.pgh.my.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import com.pgh.my.CityFragmentDirections
import com.pgh.my.networking.WeatherApi
import com.pgh.my.networking.models.WeatherResponse
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val weatherApi: WeatherApi
) : ViewModel() {
    val tempWeather: MutableLiveData<WeatherResponse> = MutableLiveData()

    fun getCitiData(lat: String, lon: String) {
        viewModelScope.launch {
            tempWeather.value = weatherApi.getWeatherInfo(lat, lon)
        }
    }
}


