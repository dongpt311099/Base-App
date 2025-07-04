package com.example.baseapplication.ui.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class IntroPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
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