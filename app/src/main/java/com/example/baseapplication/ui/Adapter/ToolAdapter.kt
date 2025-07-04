package com.example.baseapplication.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.baseapplication.R
import com.example.baseapplication.ui.model.ToolItem

class ToolAdapter(
    private val list: List<ToolItem>,
) : RecyclerView.Adapter<ToolAdapter.ToolViewHolder>() {
    inner class ToolViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val toolImage: ImageView = view.findViewById(R.id.img_tool)
        val name: TextView = view.findViewById(R.id.tool_name)
        val nameDetail: TextView = view.findViewById(R.id.tool_name_detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToolViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_tool_item, parent, false)
        return ToolViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ToolViewHolder, position: Int) {
        val tool = list[position]
        holder.toolImage.setImageResource(tool.img)
        holder.name.text = tool.name
        holder.nameDetail.text = tool.nameDetail

        val comingSoonText = holder.itemView.findViewById<TextView>(R.id.coming_soon_text)

        if(tool.isComingSoon){
            comingSoonText.visibility = View.VISIBLE
            holder.itemView.alpha = 0.5f
            holder.itemView.isEnabled = false
        }
        else{
            comingSoonText.visibility = View.GONE
            holder.itemView.alpha =1.0f
            holder.itemView.isEnabled = true
            holder.itemView.setOnClickListener{
                Toast.makeText(holder.itemView.context, "${tool.name}", Toast.LENGTH_SHORT).show()
            }
        }

    }


}