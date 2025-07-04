package com.example.baseapplication

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.baseapplication.databinding.ActivityPersonalLoanBinding
import com.example.baseapplication.databinding.FragmentHomeBinding

class PersonalLoanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPersonalLoanBinding

    private var currentLayout = "form"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPersonalLoanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val formatLayout = findViewById<View>(R.id.format_layout_person_loan)
        val resultLayout = findViewById<View>(R.id.result_person_layout)
        val detailLayout = findViewById<View>(R.id.form_view_detail_personal_loan)

        currentLayout = "form"
        formatLayout.visibility = View.VISIBLE
        resultLayout.visibility = View.GONE
        detailLayout.visibility = View.GONE


        val viewDetail = findViewById<View>(R.id.view_detail_personal_loan)
        viewDetail.setOnClickListener {
            formatLayout.visibility = View.GONE
            resultLayout.visibility = View.GONE
            detailLayout.visibility = View.VISIBLE
            currentLayout = "detail"
        }

        val backButton = findViewById<View>(R.id.toolbar_img)
        backButton.setOnClickListener {
            when (currentLayout) {
                "detail" -> {
                    detailLayout.visibility = View.GONE
                    resultLayout.visibility = View.VISIBLE
                    formatLayout.visibility = View.GONE
                    currentLayout = "result"
                }

                "result" -> {
                    resultLayout.visibility = View.GONE
                    formatLayout.visibility = View.VISIBLE
                    detailLayout.visibility = View.GONE
                    currentLayout = "form"
                }

                "form" -> {
                    finish()
                }
            }
        }

        val backToHome = findViewById<TextView>(R.id.back_to_home)
        backToHome.setOnClickListener {
            finish()
        }

        val loanAmountInput = findViewById<EditText>(R.id.loanAmountInput)
        val interestRateInput = findViewById<EditText>(R.id.expected_interest_rate_input)
        val loanTermInput = findViewById<EditText>(R.id.loan_term_input)

        val loanAmountLayout =
            findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.loanAmountLayout)
        val interestRateLayout =
            findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.expected_interest_rate)
        val loanTermLayout =
            findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.loan_term_layout)

        binding.nextButtonPersonalLoan.setOnClickListener {
            val loanAmount = loanAmountInput.text.toString().trim()
            val interestRate = interestRateInput.text.toString().trim()
            val loanTerm = loanTermInput.text.toString().trim()

            var isValid = true

            if (loanAmount.isEmpty()) {
                loanAmountLayout.error = " Enter a valid number (maximum of 999 999 999 999)"
                isValid = false
            } else {
                loanAmountLayout.error = null
            }

            if (interestRate.isEmpty()) {
                interestRateLayout.error = "Enter a valid number (maximum of 99)"
                isValid = false
            } else {
                interestRateLayout.error = null
            }

            if (loanTerm.isEmpty()) {
                loanTermLayout.error = "Enter a valid number (maximum of 360 months or 30 years)"
                isValid = false
            } else {
                loanTermLayout.error = null
            }

            if (isValid) {
                formatLayout.visibility = View.GONE
                resultLayout.visibility = View.VISIBLE
                detailLayout.visibility = View.GONE
                currentLayout = "result"
            }
        }


    }
}
