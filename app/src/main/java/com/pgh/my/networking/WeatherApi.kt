package com.pgh.my.networking

import com.pgh.my.PollutionResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("${NetworkComponent.API_POLLUTION}")
    suspend fun getPollutionInfo(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String = NetworkComponent.PRIVATE_API_KEY
    ): PollutionResponse

    @GET("${NetworkComponent.API_WEATHER}")
    suspend fun getWeatherInfo(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String = NetworkComponent.PRIVATE_API_KEY
    ): Temperature
}