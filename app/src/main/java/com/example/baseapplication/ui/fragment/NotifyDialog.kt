package com.example.baseapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.baseapplication.databinding.DialogNotifyBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NotifyDialog : BottomSheetDialogFragment() {

    private lateinit var binding: DialogNotifyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DialogNotifyBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

}