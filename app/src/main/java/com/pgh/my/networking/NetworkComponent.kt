package com.pgh.my.networking

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkComponent {

    private val gson = Gson()

    private val okHttpClient = OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()

    val weatherApi: WeatherApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .baseUrl(API_URL + API_VER )
            .build()
            .create(WeatherApi::class.java)


    companion object {
        private const val API_URL = "https://api.openweathermap.org/data/"
        private const val API_VER = "2.5/"
        const val API_POLLUTION = "air_pollution"
        const val API_WEATHER = "weather"
        const val API_KOIN = "onecal"
        const val PRIVATE_API_KEY = "1ede803bab758fa95676a5656f201ed7"
        const val KOIN="https://api.openweathermap.org/data/2.5/onecall?lat=55.90&lon=49.07&units=metric&exclude=minutely&appid=1ede803bab758fa95676a5656f201ed7"
    }
}