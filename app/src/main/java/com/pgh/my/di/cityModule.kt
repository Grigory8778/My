package com.pgh.my.di

import com.google.gson.Gson
import com.pgh.my.API_URL
import com.pgh.my.API_VER
import com.pgh.my.viewModel.WeatherViewModel
import com.pgh.my.networking.WeatherApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val cityModule = module {

    val gson = Gson()
    val okHttpClient = OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
        .build()

    val weatherApi: WeatherApi =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(API_URL+ API_VER)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(WeatherApi::class.java)


    single <WeatherApi> { weatherApi }
    single { WeatherViewModel(get()) }


}