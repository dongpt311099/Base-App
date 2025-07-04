package loan.personal.quickloan.utils.loan.tools

import kotlin.math.pow
import kotlin.math.round

data class SIPData(val totalInvestment: Double, val maturityAmount: Double){
    var multiplicationFactor: Double = Math.round(maturityAmount / totalInvestment * 10.0) / 10.0
}

class SIPCalculator {
    var monthlySIPAmount: Double = 0.0
    var period: Int = 0
    var periodType: PeriodType = PeriodType.Month
    var expectedRateInPercentYearly: Float = 0f

    fun calcSIP(): SIPData {
        if(expectedRateInPercentYearly == 0f) throw IllegalArgumentException("Annual rate can not be zero")

        val totalNumberOfPayment = if(periodType == PeriodType.Month) period else 12 * period
        val totalInvestment = monthlySIPAmount * totalNumberOfPayment
        val expectedRateMonthly = (expectedRateInPercentYearly/100) / 12

        val maturityAmount = monthlySIPAmount * (((1 + expectedRateMonthly).pow(totalNumberOfPayment) - 1 ) / expectedRateMonthly) * (1 + expectedRateMonthly)

        return SIPData(totalInvestment = totalInvestment, maturityAmount = round(maturityAmount))
    }
}