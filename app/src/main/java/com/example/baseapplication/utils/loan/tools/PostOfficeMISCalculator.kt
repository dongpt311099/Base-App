package loan.personal.quickloan.utils.loan.tools

import kotlin.math.round

data class PostOfficeMISData(val monthlyIncome: Double){}

class PostOfficeMISCalculator {
    var yearlyInvestment : Double = 0.0
    var interestRate : Float = 0f

    fun calcPostOfficeMIS(): PostOfficeMISData {
        if(interestRate < 0f || yearlyInvestment < 0.0) throw IllegalArgumentException("Annual rate can not be negative")

        val monthlyIncome = (yearlyInvestment * interestRate) / (12 * 100)

        return PostOfficeMISData(monthlyIncome = round(monthlyIncome*100)/100)
    }
}