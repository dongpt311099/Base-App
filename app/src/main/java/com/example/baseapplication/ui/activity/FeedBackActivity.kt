package com.example.baseapplication.ui.activity

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.baseapplication.R
import com.example.baseapplication.databinding.ActivityFeedBackBinding

class FeedBackActivity : BaseActivity() {

    private lateinit var binding:ActivityFeedBackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityFeedBackBinding.inflate(layoutInflater)
        setOption()
        setOnClick()
        setContentView(binding.root)
    }
    private fun setOption(){
        val listOptions=listOf<TextView>(
            binding.op1,
            binding.op2,
            binding.op3,
            binding.op4,
            binding.op5,
        )

        listOptions.forEach { option->
            option.setOnClickListener {
                it.isSelected=!it.isSelected
            }
        }
    }

    private fun setOnClick(){
        binding.returnBtn.setOnClickListener {
            finish()
        }
    }

}