package com.pgh.my.ViewModel

import android.os.Parcel
import android.os.Parcelable
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.pgh.my.networking.SingletonsProvider
import kotlinx.coroutines.launch
import org.koin.core.KoinApplication.Companion.init

open class MainViewModel(
    val singletonsProvider: SingletonsProvider
    ) : ViewModel() {

    val dataWeather: MutableLiveData<String> = MutableLiveData()

    init {
        viewModelScope.launch {
            dataWeather.value = "Привет" }

    }

}

