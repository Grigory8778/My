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

    private var isPollutionCall = true
    private lateinit var textView3: TextView
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var textView4: TextView
    private val viewModelPollution by viewModel<WeatherViewModel>()
    private val args: WeatherFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pollution, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView1 = view.findViewById(R.id.weather_fragment_show_text_temp)
        textView3 = view.findViewById(R.id.weather_fragment_show_info_temp_text_view)
        textView4 = view.findViewById(R.id.weather_fragment_show_info_humidity_text_view)
        textView2 = view.findViewById(R.id.weather_fragment_show_text_humidity)
        viewModelPollution.getCitiData(args.lat, args.lon)
        getInfoPollution()
        view.findViewById<Button>(R.id.weather_fragment_button).setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_weatherFragment_to_cityFragment)
            isPollutionCall = !isPollutionCall
        }
    }

    private fun getInfoPollution() {
        val resp = try {
            viewModelPollution.tempPollution.observe(viewLifecycleOwner) { value ->
                textView3.text = value.main.temp.toString()
            }
            viewModelPollution.tempPollution.observe(viewLifecycleOwner) { value ->
                textView4.text = value.main.humidity.toString()
            }
        } catch (e: Exception) {
            null
        }
        textView3.text = if (resp == null) "Пусто"
        else
            resp.toString()
    }
}
