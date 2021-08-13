package com.pgh.my.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pgh.my.networking.WeatherApi
import com.pgh.my.networking.models.WeatherResponse
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val weatherApi: WeatherApi
) : ViewModel() {
    val tempPollution: MutableLiveData<WeatherResponse> = MutableLiveData()

    fun getCitiData(lat: String, lon: String) {
        viewModelScope.launch {
            tempPollution.value = weatherApi.getWeatherInfo(lat, lon)
        }
    }
}


