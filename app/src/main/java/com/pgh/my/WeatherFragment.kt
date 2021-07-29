package com.pgh.my

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.pgh.my.networking.WeatherApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


class WeatherFragment : Fragment() {
    private val mainScope = MainScope()
    private var isPollutionCall = true
    private lateinit var weatherApi: WeatherApi
    private lateinit var textView: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weatherApi = (requireActivity().applicationContext as SingletonsProvider).getWeatherApi()
        savedInstanceState?.let {
            isPollutionCall = it.getBoolean(NETWORK_CALL_STATE)
        }

        textView = view.findViewById(R.id.txt_mmm)
        progressBar = view.findViewById(R.id.progressBar)

        view.findViewById<Button>(R.id.button).setOnClickListener {
            getInfo()
            isPollutionCall = !isPollutionCall
        }
        getInfo()

    }

    private fun getInfo() {

        mainScope.launch {
            if (isPollutionCall) {
                progressBar.visibility = View.VISIBLE
                textView.text = weatherApi.getPollutionInfo(55.90, 49.07).toString()
                progressBar.visibility = View.GONE
            } else {
                progressBar.visibility = View.VISIBLE
                textView.text = weatherApi.getWeatherInfo(55.90, 49.07).toString()
                progressBar.visibility = View.GONE
            }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(NETWORK_CALL_STATE, isPollutionCall)
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
