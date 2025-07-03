package com.example.baseapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.baseapplication.R
import com.example.baseapplication.ui.model.LanguageItem

class LanguageAdapter(
    private val languageList: List<LanguageItem>
) : RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {
    inner class LanguageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val flagImage: ImageView = view.findViewById(R.id.flagImage)
        val languageText: TextView = view.findViewById(R.id.languageText)
        val radioButton: ImageView = view.findViewById(R.id.languageRadioButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.language_item, parent, false)
        return LanguageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return languageList.size
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        val language = languageList[position]
        holder.flagImage.setImageResource(language.flagResID)
        holder.languageText.text = language.name
        holder.radioButton.setImageResource(R.drawable.radio_button)
    }

}
