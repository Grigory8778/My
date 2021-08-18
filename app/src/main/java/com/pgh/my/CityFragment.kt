package com.pgh.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pgh.my.Resycler.CityAddAdapter
import com.pgh.my.Resycler.OnInfoClick
import com.pgh.my.viewModel.CityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class CityFragment() : Fragment(), OnInfoClick {
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
        val adapter = CityAddAdapter(this)
        rs.layoutManager = layoutManager
        rs.adapter = adapter
        viewModel.dataWeather.observe(viewLifecycleOwner) { value ->
            adapter.updateData(value)
        }
    }

    override fun onClickListener(view: View, lat: String, lon: String) {
        Navigation.findNavController(view)
            .navigate(CityFragmentDirections.actionCityFragmentToWeatherFragment(lon, lat))
    }
}
