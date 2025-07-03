package com.example.baseapplication.ui.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.baseapplication.ui.adapter.LanguageAdapter
import com.example.baseapplication.ui.model.LanguageItem
import android.content.Intent
import com.example.baseapplication.R
import com.example.baseapplication.databinding.ActivityLanguageBinding

class Language : BaseActivity() {

    private lateinit var binding : ActivityLanguageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val languageList = listOf(
            LanguageItem("English", R.drawable.flag4),
            LanguageItem("हिन्दी", R.drawable.green_flag),
            LanguageItem("Española", R.drawable.flag2),
            LanguageItem("ประเทศไทย", R.drawable.flag1),
            LanguageItem("Português brasileiro", R.drawable.flag3)
        )
        val recyclerView= binding.languageRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = LanguageAdapter(languageList)
        val doneButton = findViewById<ImageView>(R.id.languageDone)
        doneButton.setOnClickListener{
            val intent = Intent(this, IntroActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}