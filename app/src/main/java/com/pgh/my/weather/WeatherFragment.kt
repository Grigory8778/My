package com.pgh.my.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.pgh.my.R
import com.pgh.my.viewModel.WeatherViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


open class WeatherFragment : Fragment() {

    private lateinit var textInfoTemp: TextView
    private lateinit var textNameTemp: TextView
    private lateinit var textNameHumiditi: TextView
    private lateinit var textInfoHumiditi: TextView
    private val weatherViewModel by viewModel<WeatherViewModel>()
    private val args: WeatherFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textNameTemp = view.findViewById(R.id.weather_fragment_tv_temp)
        textInfoHumiditi = view.findViewById(R.id.weather_fragment_tv_humidity_info)
        textInfoTemp = view.findViewById(R.id.weather_fragment_tv_temp_info)
        textNameHumiditi = view.findViewById(R.id.weather_fragment_tv_humidity)
        weatherViewModel.getCitiData(args.lat, args.lon)
        getInfoWeather()
        view.findViewById<Button>(R.id.weather_fragment_button).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_weatherFragment_to_cityFragment)
        }
    }

    private fun getInfoWeather() {
        weatherViewModel.tempWeather.observe(viewLifecycleOwner) { value ->
            textInfoTemp.text = value.main.temp.toString()
        }
        weatherViewModel.tempWeather.observe(viewLifecycleOwner) { value ->
            textInfoHumiditi.text = value.main.humidity.toString()
        }
    }
}
