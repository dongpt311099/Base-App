package com.example.baseapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.baseapplication.R
import com.example.baseapplication.databinding.DialogErrorBinding


class ErrorDialog : DialogFragment() {

    private lateinit var binding: DialogErrorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DialogErrorBinding.inflate(layoutInflater,container,false)
        setContent()
        return binding.root
    }

    private fun setContent(){

        binding.closeBtn.setOnClickListener {
            dismiss()
        }
    }
}