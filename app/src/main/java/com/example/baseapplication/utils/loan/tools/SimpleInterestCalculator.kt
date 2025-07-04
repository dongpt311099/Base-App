package loan.personal.quickloan.utils.loan.tools

import kotlin.math.round

data class SimpleInterestData(val totalInterest: Double, val principalAmount: Double){
    var finalBalance: Double = totalInterest + principalAmount
}

class SimpleInterestCalculator {
    var principalAmount: Double = 0.0
    var annualInterestRate: Float = 0f
    var term: Int = 0
    var termType: PeriodType = PeriodType.Month

    fun calcSimpleInterest(): SimpleInterestData {
        if(principalAmount < 0){
            throw IllegalArgumentException("principalAmount cannot be negative")
        }

        if(annualInterestRate < 0){
            throw IllegalArgumentException("annualInterestRate cannot be negative")
        }

        if(term < 0){
            throw IllegalArgumentException("term cannot be negative")
        }

        val totalInterest = when(termType){
            PeriodType.Year -> principalAmount * (annualInterestRate / 100) * term
            PeriodType.Month -> ( (principalAmount * (annualInterestRate / 100)) / 12 ) * term
        }

        return SimpleInterestData(
            totalInterest = round(totalInterest),
            principalAmount = principalAmount
        )
    }
}