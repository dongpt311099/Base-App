package com.example.baseapplication.ui.fragment

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.baseapplication.R
import com.example.baseapplication.databinding.FragmentSettingsBinding
import com.example.myapplication.Adapter.SettingAdapter
import com.example.baseapplication.ui.Domain.SettingOption
import com.example.baseapplication.ui.activity.FeedBackActivity
import com.example.baseapplication.ui.activity.ContentActivity as ContentActivity

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSettingsBinding.inflate(layoutInflater,container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSettingsRecycler()
    }


    private fun setSettingsRecycler(){
        val layoutManager : RecyclerView.LayoutManager= LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        binding.ListSettings.layoutManager=layoutManager

        val options= listOf(
            SettingOption.LANGUAGE,
            SettingOption.RATE,
            SettingOption.SHARE,
            SettingOption.FEEDBACK,
            SettingOption.POLICY,
        )

        val adapter=SettingAdapter(options) {option ->
            when(option){
                SettingOption.LANGUAGE->{}
                SettingOption.RATE->{
                    val dialogRate = RateDialog()
                    dialogRate.show(requireActivity().supportFragmentManager, "dialogRate")
                }
                SettingOption.SHARE->{}
                SettingOption.FEEDBACK->{
                    val intent= Intent(requireContext(), FeedBackActivity::class.java)
                    startActivity(intent)
                }
                SettingOption.POLICY->{}
            }
        }

        binding.ListSettings.adapter=adapter
    }

}