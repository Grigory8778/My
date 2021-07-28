package com.pgh.my


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pgh.my.networking.WeatherApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val mainScope = MainScope()
    private var isPollutionCall = true

    private lateinit var weatherApi: WeatherApi

    private lateinit var textView: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        weatherApi = (applicationContext as SingletonsProvider).getWeatherApi()
        savedInstanceState?.let {
            isPollutionCall = it.getBoolean(NETWORK_CALL_STATE)
        }

        textView = findViewById(R.id.txt_mmm)
        progressBar = findViewById(R.id.progressBar)

        findViewById<Button>(R.id.button).setOnClickListener {
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