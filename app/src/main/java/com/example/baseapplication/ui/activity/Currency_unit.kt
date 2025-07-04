package com.example.baseapplication.ui.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.baseapplication.R
import com.example.baseapplication.databinding.ActivityCurrencyUnitBinding
import com.example.baseapplication.ui.adapter.CurrencyUnitAdapter
import com.example.baseapplication.ui.adapter.LanguageAdapter
import com.example.baseapplication.ui.model.CurrencyUnitItem

class Currency_unit : BaseActivity() {

    private lateinit var binding: ActivityCurrencyUnitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCurrencyUnitBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.currencyDone.isEnabled = false

        val listCurrency = listOf(
            CurrencyUnitItem("INR", R.drawable.img_inr, "Indian Rupee"),
            CurrencyUnitItem("USD", R.drawable.img_usa, "United States Dollar"),
            CurrencyUnitItem("NGN", R.drawable.image_ngn, "Nigerian Naira"),
            CurrencyUnitItem("PKR", R.drawable.imag_pkge, "Pakistani Rupee"),
            CurrencyUnitItem("THB", R.drawable.img_thb, "Thai Baht"),
            CurrencyUnitItem("AED", R.drawable.img_aed, "Emirati Dirham"),
            CurrencyUnitItem("PHP", R.drawable.img_php, "Philippine Peso"),
            CurrencyUnitItem("PHP", R.drawable.img_php, "Philippine Peso"),
            CurrencyUnitItem("PHP", R.drawable.img_php, "Philippine Peso"),
            CurrencyUnitItem("PHP", R.drawable.img_php, "Philippine Peso"),
        )
        val recyclerView = binding.listCurrency
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CurrencyUnitAdapter(listCurrency){
            binding.currencyDone.setImageResource(R.drawable.ic_done)
            binding.currencyDone.isEnabled = true
        }

        binding.currencyDone.setOnClickListener {
            val intent = Intent(this, ContentActivity::class.java)
            startActivity((intent))
        }
    }
}