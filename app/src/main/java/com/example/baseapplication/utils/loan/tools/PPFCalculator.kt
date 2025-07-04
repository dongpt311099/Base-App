package loan.personal.quickloan.utils.loan.tools

import kotlin.math.pow

data class PPFData(val totalInvestment: Double, val maturityAmount: Double){
    var totalInterest: Double = maturityAmount - totalInvestment
}

class PPFCalculator {
    var yearlyInvestment : Double = 0.0
    var interestRate : Float = 0f
    var investmentDuration : Float = 0f

    fun calcPPF(): PPFData {
        if(interestRate < 0f) throw IllegalArgumentException("Annual rate can not be negative")

        val totalInvestment = investmentDuration * yearlyInvestment
        val maturityAmount = (yearlyInvestment * ((1+ (interestRate/100)).pow(investmentDuration) - 1) / (interestRate/100)) * (1 + (interestRate/100))

        return PPFData(totalInvestment = totalInvestment, maturityAmount = maturityAmount)
    }
}