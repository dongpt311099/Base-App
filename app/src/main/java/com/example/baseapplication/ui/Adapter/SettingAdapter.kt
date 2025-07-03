package com.example.myapplication.Adapter

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseapplication.databinding.ViewholderSettingsBinding
import com.example.baseapplication.ui.Domain.SettingOption

class SettingAdapter(private val items : List<SettingOption>, private val onItemClick:(SettingOption)->Unit): RecyclerView.Adapter<SettingAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ViewholderSettingsBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(option: SettingOption){
            binding.iconSetting.setImageResource(option.iconRes)
            binding.txtTitle.text=option.title

            binding.root.setOnClickListener{
                onItemClick(option)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingAdapter.ViewHolder {
        val binding=ViewholderSettingsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SettingAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }


}