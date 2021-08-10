package com.pgh.my

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pgh.my.databinding.FragmentViewBinding
import com.pgh.my.databinding.FragmentWeatherBinding

class ViewFragment : Fragment() {
    private lateinit var binding: FragmentViewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentViewBinding.inflate(inflater,container,false)
        return binding.root
    }
}