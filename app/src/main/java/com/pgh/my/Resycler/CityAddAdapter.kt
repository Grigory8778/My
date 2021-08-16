package com.pgh.my.Resycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.pgh.my.CityFragmentDirections
import com.pgh.my.R


class CityAddAdapter() : RecyclerView.Adapter<CityAddAdapter.StViewHonder>() {
    private val list = ArrayList<Array<String>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StViewHonder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return StViewHonder(view)
    }

    override fun onBindViewHolder(holder: StViewHonder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateData(items: Array<Array<String>>) {
        list.addAll((items))
        notifyDataSetChanged()
    }

    class StViewHonder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: Array<String>) {
            val lon = model[8]
            val lat = model[10]
            val bt = itemView.findViewById<Button>(R.id.button_list_item)
            bt.text = model[1]

            bt.setOnClickListener {

                val action = CityFragmentDirections.actionCityFragmentToWeatherFragment(
                    lon, lat
                )
                Navigation.findNavController(itemView).navigate(action)
            }
        }
    }
}
