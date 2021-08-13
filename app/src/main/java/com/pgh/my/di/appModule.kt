package com.pgh.my

import com.google.gson.Gson
import com.pgh.my.viewModel.CityViewModel
import com.pgh.my.di.API_URL_CITY
import com.pgh.my.networking.CityApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    val gson = Gson().newBuilder().setLenient().create()
    val okHttpClient = OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
        .build()

    val cityApi: CityApi? =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(API_URL_CITY)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(CityApi::class.java)

    single <CityApi> { cityApi!! }
    single { CityViewModel(get()) }


    }


