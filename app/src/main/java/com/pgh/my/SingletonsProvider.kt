package com.pgh.my

import com.pgh.my.networking.WeatherApi



interface SingletonsProvider {

    fun getWeatherApi(): WeatherApi

}