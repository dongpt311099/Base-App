package com.example.baseapplication.ui.activity

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Adapter
import androidx.activity.enableEdgeToEdge
import com.example.baseapplication.R
import com.example.baseapplication.databinding.ActivityTimeZoneBinding
import com.example.baseapplication.ui.Adapter.TimeZSpinnerAdapter
import com.example.baseapplication.ui.Domain.Country
import com.example.baseapplication.ui.Domain.TimeZone
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class TimeZoneActivity : BaseActivity() {

    private lateinit var binding: ActivityTimeZoneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTimeZoneBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.timeLayout.setOnClickListener {
            openTimeDialog()
        }
        binding.dateLayout.setOnClickListener {
            openDateDialog()
        }

        setSpinner()

        setOnClick()

        binding.timezBeforeTxt.text=binding.timezBefore.selectedItem.toString()
        binding.timezAfterTxt.text=binding.timezAfter.selectedItem.toString()

    }

    private fun setSpinner(){
        val timezones=listOf(
            TimeZone.A,
            TimeZone.B
        )
        val adapter = TimeZSpinnerAdapter(this,timezones)
        binding.timezBefore.adapter = adapter
        binding.timezAfter.adapter = adapter
    }
    
    private fun openTimeDialog(){
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val dialog= TimePickerDialog(this,R.style.DateTimeDialogTheme, TimePickerDialog.OnTimeSetListener{_, selectedHour, selectedMinute->
            binding.timeBefore.text=String.format("%02d:%02d", selectedHour, selectedMinute)
        },hour,minute,true)
        dialog.show()
    }
    private fun openDateDialog(){
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val dialog= DatePickerDialog(this,R.style.DateTimeDialogTheme, DatePickerDialog.OnDateSetListener{_, selectedYear, selectedMonth,selectedDay->
            val selectedDate = Calendar.getInstance()
            selectedDate.set(selectedYear, selectedMonth, selectedDay)

            val formatter = SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH)
            val formattedDate = formatter.format(selectedDate.time)

            binding.dateBefore.text=formattedDate
        },year, month, day)
        dialog.show()
    }

    private fun setOnClick(){
        binding.exchangeBtn.setOnClickListener {
            binding.timeAfter.text=binding.timeBefore.text
            binding.dateAfter.text=binding.dateBefore.text
        }
    }
}