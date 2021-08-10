package com.pgh.my.networking.City

import com.pgh.my.API_MEASURE_UNITS_METRIC
import com.pgh.my.API_WEATHER_DAILY
import com.pgh.my.PRIVATE_API_KEY
import com.pgh.my.networking.models.City
import com.pgh.my.networking.models.WeatherDailyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CityApi{


    @GET("City")
suspend fun getInfoCity(): Array<Array<String>>
}


