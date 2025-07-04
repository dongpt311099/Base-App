package com.example.baseapplication.ui.activity

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import com.example.baseapplication.R
import com.example.baseapplication.databinding.ActivityFixedDepositBinding
import com.example.baseapplication.ui.Adapter.CountrySpinnerAdapter
import com.example.baseapplication.ui.Domain.Country
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class FixedDepositActivity : BaseActivity() {

    private lateinit var binding : ActivityFixedDepositBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFixedDepositBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        setSpinner()
        setOnClick()
        binding.dateLayout.setOnClickListener {
            openDateDialog()
        }
    }

    private fun setOnClick(){
        binding.returnBtn.setOnClickListener {
            finish()
        }
        binding.resetBtn.setOnClickListener {
            binding.investmentTxt.text=null
            binding.interestTxt.text=null
            binding.compoundedTxt.text=null
            binding.fdTxt.text=null
            binding.startDate.text=null
        }
    }

    private fun setSpinner(){
        val countries=listOf(
            Country.VIETNAM,
            Country.USA,
        )
        val investAdapter = CountrySpinnerAdapter(this, countries)
        binding.currency.adapter = investAdapter

        val optionsFd=arrayOf("Years", "Months")
        val fdAdapter= ArrayAdapter(this, android.R.layout.simple_spinner_item,optionsFd)
        fdAdapter.setDropDownViewResource(R.layout.spinner_item_basic)
        binding.fdSpinner.adapter=fdAdapter

        val optionsCompound=arrayOf("1", "4","12")
        val CompoundAdapter= ArrayAdapter(this, android.R.layout.simple_spinner_item, optionsCompound)
        fdAdapter.setDropDownViewResource(R.layout.spinner_item_basic)
        binding.compoundedSpinner.adapter= CompoundAdapter
    }


    private fun openDateDialog(){

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val dialog= DatePickerDialog(this, R.style.DateTimeDialogTheme, DatePickerDialog.OnDateSetListener{_, selectedYear, selectedMonth,selectedDay->
            val selectedDate = Calendar.getInstance()
            selectedDate.set(selectedYear, selectedMonth, selectedDay)

            val formatter = SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH)
            val formattedDate = formatter.format(selectedDate.time)

            binding.startDate.text = formattedDate
        },year, month, day)
        dialog.show()
    }
}