package com.pgh.my.networking.models

import com.google.gson.annotations.SerializedName

data class WeatherDailyResponse(
    @SerializedName("current")
    val currentWeather: CurrentWeather,
    @SerializedName("daily")
    val daily: List<WeatherDaily>,
    @SerializedName("hourly")
    val hourly: List<WeatherHourly>,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("timezone_offset")
    val timezone_offset: Int
)