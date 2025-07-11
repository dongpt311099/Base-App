package com.example.baseapplication.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.viewpager2.widget.ViewPager2
import com.example.baseapplication.databinding.ActivityIntroBinding
import com.example.baseapplication.ui.adapter.IntroPagerAdapter

class IntroActivity : BaseActivity() {
    private lateinit var binding : ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.viewPager
        val nextText = binding.nextIntro1

        val adapter = IntroPagerAdapter(this)
        viewPager.adapter = adapter
        binding.dotsIndicator.attachTo(viewPager)

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