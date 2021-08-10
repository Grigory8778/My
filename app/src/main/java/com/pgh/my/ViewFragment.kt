package com.pgh.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pgh.my.ViewModel.MainViewModel
import com.pgh.my.databinding.FragmentViewBinding
import com.pgh.my.databinding.FragmentWeatherBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ViewFragment : Fragment() {
    private lateinit var binding: FragmentViewBinding
    private val viewModel by viewModel<MainViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentViewBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.textViewmodelFragment.text=viewModel.dataWeather.toString()
    }
}