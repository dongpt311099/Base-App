package com.example.baseapplication.ui.activity

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.baseapplication.R
import com.example.baseapplication.ui.adapter.CurrencyUnitAdapter
import com.example.baseapplication.ui.adapter.LanguageAdapter
import com.example.baseapplication.ui.model.CurrencyUnitItem

class Currency_unit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_currency_unit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_currency_unit)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
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
        val recyclerView = findViewById<RecyclerView>(R.id.list_currency)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val currencyUnitDone = findViewById<ImageView>(R.id.currency_done)
        recyclerView.adapter = CurrencyUnitAdapter(listCurrency){
            selectedItem-> Toast.makeText(this,"${selectedItem.name}",Toast.LENGTH_SHORT).show()
            currencyUnitDone.setImageResource(R.drawable.ic_done)
        }
    }
}