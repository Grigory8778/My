package com.pgh.my

import com.google.gson.Gson
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    val gson = Gson()

    factory { OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .build() }
    single {  Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(get())
        .baseUrl(API_URL + API_VER )
        .build()
    }
}

