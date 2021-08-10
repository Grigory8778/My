package com.pgh.my.ViewModel

import android.os.Parcel
import android.os.Parcelable
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.pgh.my.networking.SingletonsProvider
import com.pgh.my.networking.WeatherApi
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.KoinApplication.Companion.init
import org.koin.java.KoinJavaComponent.inject

open class MainViewModel(
    private val weatherApi :WeatherApi
    ) : ViewModel() {
    val dataWeather: MutableLiveData<String> = MutableLiveData()

    init {
        viewModelScope.launch {
            dataWeather.value = weatherApi.getPollutionInfo(55.90, 49.07).toString() }

    }

}

