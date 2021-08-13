package com.pgh.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pgh.my.Resycler.StAdapter
import com.pgh.my.viewModel.CityViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import org.koin.androidx.viewmodel.ext.android.viewModel


class CityFragment : Fragment() {

    private val mainScope = MainScope()
    private var isWeatherCall = true
    private val viewModel by viewModel<CityViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_city, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rs = view.findViewById<RecyclerView>(R.id.recycler_city)
        val layoutManager = LinearLayoutManager(context)
        val adapter = StAdapter()
        rs.layoutManager = layoutManager
        rs.adapter = adapter
        viewModel.dataWeather.observe(viewLifecycleOwner) { value ->
            adapter.updateData(value)
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
