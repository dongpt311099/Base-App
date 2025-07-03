package com.example.baseapplication.ui.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.baseapplication.R
import com.example.baseapplication.databinding.ActivityCurrentExchangeBinding
import com.example.baseapplication.ui.Adapter.CountrySpinnerAdapter
import com.example.baseapplication.ui.Domain.Country

class CurrentExchangeActivity : BaseActivity() {

    private lateinit var binding: ActivityCurrentExchangeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityCurrentExchangeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setInputField()
        setOnClick()
        setSpinner()
    }

    private fun setSpinner(){
        val countries=listOf(
            Country.VIETNAM,
            Country.USA,
        )
        val adapter = CountrySpinnerAdapter(this, countries)
        binding.countryBefore.adapter = adapter
    }

    private fun setInputField(){
        binding.moneyBefore.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.errorTxt.visibility=View.GONE
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }


    private fun setOnClick(){

        binding.returnBtn.setOnClickListener {
            finish()
        }
        binding.resetBtn.setOnClickListener {
            binding.moneyBefore.setText("")
            binding.moneyAfter.setText("")
        }

        binding.exchangeBtn.setOnClickListener {
            val input = binding.moneyBefore.text.toString()
            val number = input.toLongOrNull()
            binding.errorTxt.visibility =
                if (number == null || number < 1 || number > 999999999999) View.VISIBLE else View.GONE
        }
    }
}