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

class Language : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_language)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val languageList = listOf(
            LanguageItem("English", R.drawable.flag4),
            LanguageItem("हिन्दी", R.drawable.green_flag),
            LanguageItem("Española", R.drawable.flag2),
            LanguageItem("ประเทศไทย", R.drawable.flag1),
            LanguageItem("Português brasileiro", R.drawable.flag3)
        )
        val recyclerView= findViewById<RecyclerView>(R.id.languageRecyclerView)
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