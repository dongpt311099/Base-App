package loan.personal.quickloan.utils.loan

data class AmortizationSchedule(
    val month: Int,
    val payment: Double,
    val interest: Double,
    val principal: Double,
    val balance: Double
)