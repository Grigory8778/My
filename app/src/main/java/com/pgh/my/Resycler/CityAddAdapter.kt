package com.pgh.my.Resycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.pgh.my.R


class CityAddAdapter(
    val onInfoClick: OnInfoClick
) : RecyclerView.Adapter<CityAddAdapter.CitiViewHolder>() {
    private val list = ArrayList<Array<String>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CitiViewHolder(view, onInfoClick)
    }

    override fun onBindViewHolder(holder: CitiViewHolder, position: Int) {

        holder.bind(list[position])

    }

    override fun getItemCount(): Int = list.size

    fun updateData(items: Array<Array<String>>) {
        list.addAll((items))
        notifyDataSetChanged()
    }

    class CitiViewHolder(view: View, val onInfoClick: OnInfoClick) : RecyclerView.ViewHolder(view) {
        val bt = itemView.findViewById<Button>(R.id.button_list_item)
        fun bind(model: Array<String>) {
            val lon = model[8]
            val lat = model[10]
            bt.setOnClickListener { onInfoClick.onClickListener(it, lat, lon) }
            bt.text = model[1]
        }
    }
}
