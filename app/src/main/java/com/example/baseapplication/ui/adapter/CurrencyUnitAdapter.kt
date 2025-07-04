package com.example.baseapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.baseapplication.R
import com.example.baseapplication.ui.data.CurrencyUnitItem

class CurrencyUnitAdapter (
    private val currencyUnit : List<CurrencyUnitItem>,
    private val itemOnclick: (CurrencyUnitItem) ->Unit
): RecyclerView.Adapter<CurrencyUnitAdapter.CurrencyUnitViewHolder>(){
    inner class CurrencyUnitViewHolder(view: View):RecyclerView.ViewHolder(view){
        val flagImage: ImageView= view.findViewById(R.id.flagCurrencyImg)
        val name: TextView = view.findViewById(R.id.currencyName)
        val nameDetail: TextView = view.findViewById(R.id.currencyNameDetail)
        val radioButton: ImageView = view.findViewById(R.id.currencyRadioButton)
    }
    private var selectedPosition = -1



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyUnitViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.currency_language_item,parent,false)
        return CurrencyUnitViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  currencyUnit.size
    }
    override fun onBindViewHolder(holder: CurrencyUnitViewHolder, position: Int) {
        val currency = currencyUnit[position]
        holder.flagImage.setImageResource(currency.flagImg)
        holder.name.text = currency.name
        holder.nameDetail.text = currency.nameDetail
        holder.radioButton.setImageResource(R.drawable.radio_button)

        if (position == selectedPosition){
            holder.radioButton.setImageResource(R.drawable.radio_button_selected)
        }else holder.radioButton.setImageResource(R.drawable.radio_button)

        holder.itemView.findViewById<View>(R.id.currencyItem).setOnClickListener{
            val previousSelected = selectedPosition
            selectedPosition = position
            notifyItemChanged(previousSelected)
            notifyItemChanged(selectedPosition)
            itemOnclick(currency)
        }
    }
}