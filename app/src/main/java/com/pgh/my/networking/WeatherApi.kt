package com.pgh.my.networking


import com.pgh.my.*
import com.pgh.my.networking.models.PollutionResponse
import com.pgh.my.networking.models.WeatherDailyResponse
import com.pgh.my.networking.models.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET(API_POLLUTION)
    suspend fun getPollutionInfo(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String = PRIVATE_API_KEY,
        @Query("units") units: String = API_MEASURE_UNITS_METRIC
    ): PollutionResponse

    @GET(API_WEATHER)
    suspend fun getWeatherInfo(
        @Query("lat") lat: String, // = &lat=88.99
        @Query("lon") lon: String, // = &lon=22.11
        @Query("appid") appid: String = PRIVATE_API_KEY,
        @Query("units") units: String = API_MEASURE_UNITS_METRIC
    ): WeatherResponse

    @GET(API_WEATHER_DAILY)
    suspend fun getDailyWeatherResponse(
        @Query("lat") lat: String, // = &lat=88.99
        @Query("lon") lon: String, // = &lon=22.11
        @Query("appid") appid: String = PRIVATE_API_KEY,
        @Query("units") units: String = API_MEASURE_UNITS_METRIC
    ): WeatherDailyResponse

//    @GET(API_NEARBY_CITIES)
//    suspend fun getInfoCity(
//        @Query("radius") radius: Int ,
//        @Query("limit") limit: Int ,
//        @Query("latitude") latitude: Double,
//        @Query("longitude") longitude: Double,
//    ): Array<Array<String>>
}