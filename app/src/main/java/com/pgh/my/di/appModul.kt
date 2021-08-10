package com.pgh.my

import com.google.gson.Gson
import com.pgh.my.ViewModel.MainViewModel
import com.pgh.my.networking.WeatherApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    val gson = Gson()
    val okHttpClient = OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build()

    val weatherApi: WeatherApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .baseUrl(API_URL + API_VER)
            .build()
            .create(WeatherApi::class.java)



    single <WeatherApi> { weatherApi }
    single { MainViewModel(get()) }
    }


