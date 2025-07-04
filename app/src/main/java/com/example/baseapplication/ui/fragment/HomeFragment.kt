package com.example.baseapplication.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.Visibility
import com.example.baseapplication.PersonalLoanActivity
import com.example.baseapplication.R
import com.example.baseapplication.databinding.FragmentHomeBinding
import com.example.baseapplication.ui.adapter.HomeAdapter
import com.example.baseapplication.ui.adapter.ToolAdapter
import com.example.baseapplication.ui.data.HomeItem

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment

        val listHomeTool = listOf(
            HomeItem("Mortgage Loan", R.drawable.frame_353),
            HomeItem("Car Loan", R.drawable.car_loan),
            HomeItem("Business Loan", R.drawable.business_loan),
            HomeItem("Fixed Deposit", R.drawable.fixed_loan),
            HomeItem("Recurring Deposit", R.drawable.recurring_loan),
            HomeItem("GST Calculator", R.drawable.gsp_loan),
            HomeItem("VAT Calculator", R.drawable.vat),
            HomeItem("Discount Calculator", R.drawable.discount)
        )

        val recyclerView = binding.homeRecyclerview
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = HomeAdapter(listHomeTool)

        binding.personalLoan.setOnClickListener {
            val intent = Intent(requireContext(), PersonalLoanActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }


}


