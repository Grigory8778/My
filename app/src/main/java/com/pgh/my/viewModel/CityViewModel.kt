package com.pgh.my.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pgh.my.networking.CityApi
import kotlinx.coroutines.launch


open class CityViewModel(
    private val cityApi: CityApi
) : ViewModel() {

    val dataWeather: MutableLiveData<Array<Array<String>>> = MutableLiveData()

    init {
        viewModelScope.launch {
            dataWeather.value = cityApi.getInfoCity(200, 5, 55.75, 48.69)
        }
    }
}

