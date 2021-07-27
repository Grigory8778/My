package com.pgh.my

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar


import android.widget.TextView
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.util.logging.Handler as Handler1

class MainActivity : AppCompatActivity() {

    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getInfo()
    }

    private fun getInfo() {
        val weatherApi = (applicationContext as SingletonsProvider).getWeatherApi()
        val txt = findViewById<TextView>(R.id.txt_mmm)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        findViewById<Button>(R.id.button).setOnClickListener {
            progressBar.visibility = View.VISIBLE
            mainScope.launch {
                //txt.text = weatherApi.getPollutionInfo(55.90, 49.07).toString()
                txt.text = weatherApi.getWeatherInfo(55.90, 49.07).toString()
            }
        }
    }

    override fun onDestroy() {
        mainScope.cancel()
        super.onDestroy()
    }
}