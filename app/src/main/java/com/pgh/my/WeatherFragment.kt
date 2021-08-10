package com.pgh.my

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.Navigation

import com.pgh.my.networking.WeatherApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import okhttp3.internal.threadName
import org.koin.android.ext.android.inject


class WeatherFragment : Fragment() {

    private val mainScope = MainScope()
    private var isWeatherCall = true
    private lateinit var textView: TextView
    private lateinit var progressBar: ProgressBar
    private val weatherApi by inject<WeatherApi>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.let {
            isWeatherCall = it.getBoolean(NETWORK_CALL_STATE)
        }
        mainScope.launch(Dispatchers.IO) {
//         App.instance.database.weatherDao().insert(Weather(8,"fsdf","Краснодар"))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedInstanceState?.let {
            isWeatherCall = it.getBoolean(NETWORK_CALL_STATE)
        }
        textView = view.findViewById(R.id.txt_weater_fragment)
        progressBar = view.findViewById(R.id.progressBar_weather_fragment)
        view.findViewById<Button>(R.id.button_weather_fragment).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_weatherFragment_to_pollutionFragment)
            isWeatherCall = !isWeatherCall
        }
        getInfoWeather()
    }

    private fun getInfoWeather() {
        mainScope.launch {
            progressBar.visibility = View.VISIBLE
            weatherApi.getInfoCity()
            progressBar.visibility = View.GONE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(NETWORK_CALL_STATE, isWeatherCall)
        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        mainScope.cancel()
        super.onDestroy()
    }

    companion object {
        const val NETWORK_CALL_STATE = "NETWORK_CALL_STATE"
    }
}
