package com.pgh.my.di

import com.google.gson.Gson
import com.pgh.my.API_VER
import com.pgh.my.ViewModel.MainViewModel
import com.pgh.my.networking.WeatherApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
//
//val cityModule = module {
//
//    val gson = Gson()
//    val okHttpClient = OkHttpClient.Builder()
//        .readTimeout(30, TimeUnit.SECONDS)
//        .writeTimeout(30, TimeUnit.SECONDS)
//        .connectTimeout(30, TimeUnit.SECONDS)
//        .build()
//
//    val cityApi: CityApi =
//        Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .client(okHttpClient)
//            .baseUrl("http://getnearbycities.geobytes.com/GetNearbyCities?radius=200&limit=5&latitude=55.75&longitude=48.69")
//            .build()
//            .create(CityApi::class.java)
//
//
//
//    single <CityApi> { cityApi }
//    single { MainViewModel(get()) }
//}