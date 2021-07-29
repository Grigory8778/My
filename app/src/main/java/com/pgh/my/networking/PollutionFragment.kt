package com.pgh.my.networking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.pgh.my.MainActivity
import com.pgh.my.R
import com.pgh.my.SingletonsProvider
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class PollutionFragment:Fragment() {
    private val mainScope = MainScope()
    private var isPollutionCall = true
    private lateinit var weatherApi: WeatherApi
    private lateinit var textView: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pollution, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weatherApi = (requireActivity().applicationContext as SingletonsProvider).getWeatherApi()
        savedInstanceState?.let {
            isPollutionCall = it.getBoolean(NETWORK_CALL_STATE_POLUTION)
        }

        textView = view.findViewById(R.id.txt_pollution_fragment)
        progressBar = view.findViewById(R.id.progressBar_pollution_fragment)

        view.findViewById<Button>(R.id.button_pollution_fragment).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_pollutionFragment_to_weatherFragment)
            isPollutionCall = !isPollutionCall
        }
        getInfoPollution()

    }
    private fun getInfoPollution() {

        mainScope.launch {
            progressBar.visibility = View.VISIBLE
            textView.text = weatherApi.getPollutionInfo(55.90, 49.07).toString()
            progressBar.visibility = View.GONE
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(NETWORK_CALL_STATE_POLUTION, isPollutionCall)
        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        mainScope.cancel()
        super.onDestroy()
    }

    companion object {
        const val NETWORK_CALL_STATE_POLUTION = "NETWORK_CALL_STATE_POLLUTION"
    }
}
