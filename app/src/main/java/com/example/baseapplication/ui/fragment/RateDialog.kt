package com.example.baseapplication.ui.fragment

import android.content.Intent
import android.content.res.Resources
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.example.baseapplication.R
import com.example.baseapplication.databinding.DialogRateBinding
import com.example.baseapplication.ui.activity.FeedBackActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class RateDialog (): BottomSheetDialogFragment() {

    private lateinit var binding : DialogRateBinding
    private lateinit var starViews: List<ImageView>
    private var currentRating = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DialogRateBinding.inflate(layoutInflater,container,false)
        setCustomRatingBar()
        setListener()
        return binding.root
    }

    private fun setListener(){
        binding.rateBtn.setOnClickListener(){
            val intent= Intent(requireContext(), FeedBackActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setCustomRatingBar(){
        starViews= listOf(
            binding.start1,
            binding.start2,
            binding.start3,
            binding.start4,
            binding.start5
        )
        for((index,star) in starViews.withIndex()){
            star.setOnClickListener(){
                setRating(index+1)
            }
        }
    }

    private fun setRating(rating:Int){
        currentRating=rating
        for(i in starViews.indices){
            val drawable = if(i<currentRating) R.drawable.star_filled else R.drawable.empty_star
            starViews[i].setImageResource(drawable)
        }

    }
}