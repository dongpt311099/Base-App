package com.example.baseapplication.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.baseapplication.R
import com.example.baseapplication.ui.fragment.IntroPagerAdapter
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class IntroActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var dotsIndicator: DotsIndicator
    private lateinit var nextText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_intro)

        viewPager = findViewById(R.id.viewPager)
        dotsIndicator = findViewById(R.id.dotsIndicator)
        nextText = findViewById(R.id.next_intro_1)

        val adapter = IntroPagerAdapter(this)
        viewPager.adapter = adapter
        dotsIndicator.attachTo(viewPager)

        nextText.setOnClickListener {
            if (viewPager.currentItem < adapter.itemCount - 1) {
                viewPager.currentItem++
            } else {
                val intent = Intent(this@IntroActivity, Currency_unit::class.java)
                startActivity(intent)
                finish()
            }
        }
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                nextText.text = if (position == adapter.itemCount -1 )"Start" else "Next"
            }
        })
    }
}