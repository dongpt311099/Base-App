package com.example.baseapplication.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.baseapplication.R
import com.example.baseapplication.databinding.ActivityFeedBackBinding
import com.example.baseapplication.databinding.FragmentToolsBinding
import com.example.baseapplication.ui.activity.CurrencyExchangeActivity
import com.example.baseapplication.ui.activity.TimeZoneActivity
import com.example.baseapplication.ui.adapter.ToolAdapter
import com.example.baseapplication.ui.data.ToolItem

class ToolsFragment : Fragment() {
    private lateinit var binding: FragmentToolsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,

        ): View {
        binding = FragmentToolsBinding.inflate(inflater, container, false)
        val toolList = listOf(
            ToolItem(
                R.drawable.img_currency,
                "Currency Exchange",
                "Easily convert between currencies and get the most up to date rates."
            ),
            ToolItem(
                R.drawable.img_time_zone,
                "Time Zone Exchange",
                "Easily convert between currencies and get the most up to date rates."
            ),
            ToolItem(
                R.drawable.img_amount,
                "Amount to Word",
                "Easily convert between currencies and get the most up to date rates.",
                true
            ),
            ToolItem(
                R.drawable.img_note,
                "Note Counter",
                "Easily convert between currencies and get the most up to date rates.",
                true
            )
        )
        val recyclerView = binding.toolRecycler
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ToolAdapter(toolList){tool->
            when (tool.name) {
                "Currency Exchange" -> {
                    val intent=Intent(requireContext(), CurrencyExchangeActivity::class.java)
                    startActivity((intent))
                }

                "Time Zone Exchange" -> {
                    val intent=Intent(requireContext(), TimeZoneActivity::class.java)
                    startActivity((intent))
                }

                "Amount to Word" -> {}

                "Note Counter" -> {}
            }

        }
        // Inflate the layout for this fragment
        return binding.root
    }


}