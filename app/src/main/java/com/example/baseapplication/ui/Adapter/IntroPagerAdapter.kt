package com.example.baseapplication.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.baseapplication.ui.fragment.IntroFragment1
import com.example.baseapplication.ui.fragment.IntroFragment2
import com.example.baseapplication.ui.fragment.IntroFragment3
import com.example.baseapplication.ui.fragment.IntroFragment4

class IntroPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 4
    override fun createFragment(position: Int): Fragment {
        return when (position){
            0-> IntroFragment1()
            1-> IntroFragment2()
            2-> IntroFragment3()
            3-> IntroFragment4()
            else -> IntroFragment1()
        }
    }
}