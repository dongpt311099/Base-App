package loan.personal.quickloan.utils.loan.tools

import kotlin.math.pow
import kotlin.math.round

/**
 * Calculates the Equated Monthly Installment (EMI) for a loan.
 *
 * @param principal The total loan amount borrowed.
 * @param annualInterestRate The annual interest rate in percentage.
 * @param tenureMonths The loan tenure in months.
 */
class EMICalculator(
    private val principal: Double,
    private val annualInterestRate: Double,
    private val tenureMonthOrYear: Int,
    private val paymentFrequency: String
) {
    var emi: Double = 0.0
        private set

    private var ratePerPeriod: Double = 0.0

    fun calculateEMI(): Double {
        if (principal <= 0 || annualInterestRate < 0 || tenureMonthOrYear <= 0) {
            throw IllegalArgumentException("Principal and tenure must be positive, interest rate cannot be negative.")
        }

        val annualRateDecimal = annualInterestRate / 100

        when (paymentFrequency.lowercase()) {
            "monthly" -> {
                ratePerPeriod = annualRateDecimal / 12
            }
            "yearly" -> {
                ratePerPeriod = annualRateDecimal
            }
            else -> throw IllegalArgumentException("Invalid payment frequency. Use 'monthly' or 'yearly'.")
        }

        val emiRaw = if (ratePerPeriod == 0.0) {
            principal / tenureMonthOrYear
        } else {
            val rateFactor = (1 + ratePerPeriod).pow(tenureMonthOrYear.toDouble())
            (principal * ratePerPeriod * rateFactor) / (rateFactor - 1)
        }

        emi = round(emiRaw * 100) / 100
        return emi
    }

    val totalPayment: Double
        get() = emi * tenureMonthOrYear

    val totalInterest: Double
        get() = totalPayment - principal
}