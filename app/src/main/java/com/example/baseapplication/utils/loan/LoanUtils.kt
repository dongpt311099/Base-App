package loan.personal.quickloan.utils.loan

import loan.personal.quickloan.model.LoanMonth
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Calendar
import java.util.Currency
import java.util.Date
import java.util.Locale
import kotlin.math.pow
import kotlin.math.round

object LoanUtils {

    fun calculateMaturityAmount(
        principal: Double,
        annualRate: Double,
        tenureMonths: Int,
        compoundingFrequency: Int
    ): Double {
        val tenureYears = tenureMonths / 12.0
        val ratePerPeriod = annualRate / (compoundingFrequency * 100)
        val totalPeriods = compoundingFrequency * tenureYears
        return principal * (1 + ratePerPeriod).pow(totalPeriods)
    }

    fun generateLoanMonth(
        loanAmount: Double,
        interestRate: Double,
        loanTerm: Int
    ): ArrayList<LoanMonth> {
        val monthlyInterestRate = interestRate / 12 / 100
        val monthlyPayment = loanAmount * (monthlyInterestRate * Math.pow(
            1 + monthlyInterestRate,
            loanTerm.toDouble()
        )) /
                (Math.pow(1 + monthlyInterestRate, loanTerm.toDouble()) - 1)

        var balance = loanAmount
        val amortizationList = arrayListOf<LoanMonth>()

        for (month in 1..loanTerm) {
            val interest = balance * monthlyInterestRate
            val principal = monthlyPayment - interest
            balance -= principal

            if (balance < 0) balance = 0.0

            amortizationList.add(
                LoanMonth(
                    month = month,
                    payment = monthlyPayment,
                    interest = interest,
                    principal = principal,
                    balance = balance
                )
            )
        }

        return amortizationList
    }

    fun calculateRecurringDeposit(
        monthlyInvestment: Double,
        interestRate: Double,
        tenureMonths: Int
    ): RDResult {
        val interestRateX = interestRate/100

        val a = monthlyInvestment * tenureMonths
        val b = monthlyInvestment * tenureMonths * (tenureMonths+1) * (interestRateX/24)

        return RDResult(
            totalInvestmentAmount = a,
            totalInterestValue = b,
            maturityValue = a+b
        )
    }

    data class RDResult(
        val totalInvestmentAmount: Double,
        val totalInterestValue: Double,
        val maturityValue: Double
    )

    private fun formatCurrencyINR(amount: Double, includeDecimal: Boolean = true): String {
        // Round the amount to two decimal places
        val roundedAmount = if(includeDecimal) String.format(Locale.US, "%.2f", amount) else String.format(Locale.US, "%.0f", round(amount))
        // Split into integer and decimal parts
        val parts = roundedAmount.split(".")
        val integerPart = parts[0]
        val decimalPart = if(includeDecimal) parts[1] else ""

        // Reverse the integer part for easier processing
        val reversedInteger = integerPart.reversed()
        val groups = mutableListOf<String>()

        var index = 0
        val length = reversedInteger.length

        // First group: take 3 digits
        if (length >= 3) {
            groups.add(reversedInteger.substring(index, index + 3))
            index += 3
        } else {
            groups.add(reversedInteger.substring(index, length))
            index = length
        }

        // Subsequent groups: take 2 digits
        while (index < length) {
            val endIndex = if (index + 2 <= length) index + 2 else length
            groups.add(reversedInteger.substring(index, endIndex))
            index += 2
        }

        // Join the groups with commas and reverse back
        val formattedInteger = groups.joinToString(",") { it }.reversed()
        return "${formattedInteger}${if(decimalPart.isNotEmpty()) "." else ""}${decimalPart}"
    }

    fun formatCurrency(amount: Double, currencyCode: String, includeSymbol: Boolean = true, includeDecimal: Boolean = true): String {
        val currencySymbolMap = mapOf(
            "INR" to "₹",
            "USD" to "$",
            "NGN" to "₦",
            "PKR" to "Rs",
            "THB" to "฿",
            "AED" to "dh",
            "PHP" to "₱",
            "KES" to "Ksh",
            "SAR" to "SAR",
            "GBP" to "£",
            "EUR" to "€",
            "IDR" to "Rp",
            "MXN" to "$",
            "SGD" to "S$"
        )

        val symbol = if(currencyCode.isNotEmpty()) currencySymbolMap[currencyCode] ?: Currency.getInstance(currencyCode).symbol else ""

        return when (currencyCode) {
            "INR" -> {
                if (includeSymbol) {
                    "$symbol${formatCurrencyINR(amount, includeDecimal = includeDecimal)}"
                } else {
                    formatCurrencyINR(amount, includeDecimal = includeDecimal)
                }
            }
            "EUR", "IDR" -> {
                val format = DecimalFormat( if(includeDecimal) "#,##0.00" else "#,##0" )
                format.decimalFormatSymbols = DecimalFormatSymbols().apply {
                    groupingSeparator = '.'
                    decimalSeparator = ','
                }
                if (includeSymbol) {
                    "$symbol${format.format(amount)}"
                } else {
                    format.format(amount)
                }
            }
            else -> {
                val format = DecimalFormat( if(includeDecimal) "#,##0.00" else "#,##0" )
                format.decimalFormatSymbols = DecimalFormatSymbols().apply {
                    groupingSeparator = ','
                    decimalSeparator = '.'
                }
                if (includeSymbol) {
                    "$symbol${format.format(amount)}"
                } else {
                    format.format(amount)
                }
            }
        }
    }

    fun parseCurrencyAmount(input: String): Pair<Double, String>? {
        val regex = Regex(
            pattern = """^\s*(?:(\d+(?:\.\d+)?)\s*([A-Z]{3})|([A-Z]{3})\s*(\d+(?:\.\d+)?)\s*)$""",
            option = RegexOption.IGNORE_CASE
        )

        val matchResult = regex.find(input)

        val data = matchResult?.let {
            val (amountBefore, currencyBefore, currencyAfter, amountAfter) = it.destructured
            val amount: Double
            val currency: String

            when {
                amountBefore.isNotEmpty() && currencyBefore.isNotEmpty() -> {
                    amount = amountBefore.toDouble()
                    currency = currencyBefore.uppercase()
                }
                currencyAfter.isNotEmpty() && amountAfter.isNotEmpty() -> {
                    amount = amountAfter.toDouble()
                    currency = currencyAfter.uppercase()
                }
                else -> return null
            }

            return Pair(amount, currency)
        }

        return data
    }

    fun calculateGSTWhenPriceWithGST(priceWithGST: Double, gstRate: Double): Double {
        require(priceWithGST >= 0) { "Price with GST must be non-negative." }
        require(gstRate >= 0) { "GST rate must be non-negative." }

        // Convert GST rate percentage to decimal
        val gstDecimal = gstRate / 100
        val gstAmount = priceWithGST * (gstDecimal / (1 + gstDecimal))

        return gstAmount
    }

    fun calculatePriceWithoutGST(priceWithoutGST: Double, gstRate: Double): Pair<Double, Double> {
        require(priceWithoutGST >= 0) { "Price excluding GST must be non-negative." }
        require(gstRate >= 0) { "GST rate must be non-negative." }

        val gstDecimal = gstRate / 100
        val gstAmount = priceWithoutGST * gstDecimal

        // Calculate total price including GST
        val totalPrice = priceWithoutGST + gstAmount

        return Pair(gstAmount, totalPrice)
    }

    fun formatDouble(value: Double): String {
        return if (value % 1.0 == 0.0) {
            value.toInt().toString()
        } else {
            value.toString()
        }
    }

    fun addFractionalYears(startDate: Date, fractionalYears: Float): Date {
        val calendar = Calendar.getInstance()
        calendar.time = startDate

        val wholeYears = fractionalYears.toInt()
        val fractionalYear = fractionalYears - wholeYears

        calendar.add(Calendar.YEAR, wholeYears)

        val monthsToAdd = (fractionalYear * 12).toInt()
        val fractionalMonth = fractionalYear * 12 - monthsToAdd

        calendar.add(Calendar.MONTH, monthsToAdd)

        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val daysToAdd = (fractionalMonth * daysInMonth).toInt()

        calendar.add(Calendar.DAY_OF_MONTH, daysToAdd)

        return calendar.time
    }
}