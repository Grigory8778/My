package com.pgh.my

import android.app.Application
import com.pgh.my.networking.NetworkComponent
import com.pgh.my.networking.WeatherApi

class App : Application(), SingletonsProvider {

    private val singletonsHolder = HashMap<Any, Any>()
//    val _weatherApi: WeatherApi by lazy {
//        NetworkComponent().weatherApi
//    }

    override fun getWeatherApi(): WeatherApi {

        if (singletonsHolder[WeatherApi::class.java.simpleName] == null) {
            singletonsHolder[WeatherApi::class.java.simpleName] = NetworkComponent().weatherApi
        }
        return singletonsHolder[WeatherApi::class.java.simpleName] as WeatherApi
//        return _weatherApi
    }


}
