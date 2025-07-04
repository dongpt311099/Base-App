package loan.personal.quickloan.utils.loan.tools

import kotlin.math.pow

data class InflationData(val finalPrice: Double, val initialPrice: Double){
    val priceDifference = finalPrice - initialPrice
    val cumulativeInflationRate = (priceDifference / initialPrice) * 100
}

class InflationCalculator {
    var startYear: Int = 0
    var endYear: Int = 0
    var annualInflationRate: Float = 0f
    var initialPrice: Double = 0.0

    fun calcInflation(): InflationData {
        if(annualInflationRate < 0) throw IllegalArgumentException("Annual inflation rate can not be negative")
        if(endYear < startYear) throw IllegalArgumentException("EndYear must be greater than StartYear")

        val rate = annualInflationRate / 100
        val finalPrice = initialPrice * (1 + rate).pow(endYear - startYear)

        return InflationData(finalPrice = finalPrice, initialPrice = initialPrice)
    }
}