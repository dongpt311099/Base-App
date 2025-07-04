package loan.personal.quickloan.utils.loan.tools

data class MortgageResult(
    val totalMonthlyPayment: Double,
    val totalPayment: Double,
    val totalPrincipalAndInterest: Double,
    val principalAndInterestPercent: Double,
    val propertyTaxPercent: Double,
    val pmiPercent: Double,
    val homeownersInsurancePercent: Double,
    val hoaFeesPercent: Double
)

class MortgageCalculator(
    val homePrice: Double,
    val downPayment: Double,
    val interestRate: Double,
    val loanTenureYears: Int,
    val propertyTax: Double,
    val pmi: Double,
    val homeownersInsurance: Double,
    val hoaFees: Double
) {
    fun calculateMortgage(
        homePrice: Double,
        downPayment: Double,
        interestRate: Double,
        loanTenureYears: Int,
        propertyTax: Double,
        pmi: Double,
        homeownersInsurance: Double,
        hoaFees: Double
    ): MortgageResult {
        // Calculations
        val loanAmount = homePrice - downPayment
        val monthlyInterestRate = interestRate / 100 / 12
        val numberOfPayments = loanTenureYears * 12

        val monthlyFactor = Math.pow(1 + monthlyInterestRate, numberOfPayments.toDouble())
        val monthlyPrincipalAndInterest = loanAmount * (monthlyInterestRate * monthlyFactor) / (monthlyFactor - 1)

        // Additional monthly costs
        val totalMonthlyPayment = monthlyPrincipalAndInterest + propertyTax + pmi + homeownersInsurance + hoaFees

        // Total payments over the loan period
        val totalPayment = totalMonthlyPayment * numberOfPayments
        val totalPrincipalAndInterest = monthlyPrincipalAndInterest

        // Percentage calculations
        val principalAndInterestPercent = (totalPrincipalAndInterest / totalMonthlyPayment) * 100
        val propertyTaxPercent = (propertyTax / totalMonthlyPayment) * 100
        val pmiPercent = (pmi / totalMonthlyPayment) * 100
        val homeownersInsurancePercent = (homeownersInsurance / totalMonthlyPayment) * 100
        val hoaFeesPercent = (hoaFees / totalMonthlyPayment) * 100

        return MortgageResult(
            totalMonthlyPayment,
            totalPayment,
            totalPrincipalAndInterest,
            principalAndInterestPercent,
            propertyTaxPercent,
            pmiPercent,
            homeownersInsurancePercent,
            hoaFeesPercent
        )
    }
}