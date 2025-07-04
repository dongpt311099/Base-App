package com.example.baseapplication.ui.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.baseapplication.R
import com.example.baseapplication.ui.Domain.Country

class CountrySpinnerAdapter(
    private val context: Context,
    private val countries: List<Country>
) : BaseAdapter() {

    override fun getCount() = countries.size

    override fun getItem(position: Int) = countries[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createView(position, convertView, parent)
    }

    private fun createView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.spinner_item_country, parent, false)
        val flag = view.findViewById<ImageView>(R.id.ic_flag)
        val cur_symbol = view.findViewById<TextView>(R.id.cur_symbol)
        val currency = view.findViewById<TextView>(R.id.currency)

        val country = countries[position]
        flag.setImageResource(country.iconRes)
        currency.text = country.currency
        cur_symbol.text=country.cur_symbol

        return view
    }
}
