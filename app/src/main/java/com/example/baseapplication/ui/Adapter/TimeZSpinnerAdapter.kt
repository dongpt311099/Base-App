package com.example.baseapplication.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.baseapplication.R
import com.example.baseapplication.ui.Domain.TimeZone

class TimeZSpinnerAdapter (
    private val context : Context,
    private val timezones : List<TimeZone>
): BaseAdapter(){

    private val inflater = LayoutInflater.from(context)

    override fun getCount() = timezones.size

    override fun getItem(position: Int) = timezones[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView
            ?: inflater.inflate(R.layout.spinner_timez_selected, parent, false)
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createView(position, convertView, parent)
    }

    private fun createView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.spinner_item_timez, parent, false)
        val timez=view.findViewById<TextView>(R.id.timez_spinner_txt)

        val timezone = timezones[position]
        timez.text="${timezone.utc}, ${timezone.location}"

        return view
    }
}