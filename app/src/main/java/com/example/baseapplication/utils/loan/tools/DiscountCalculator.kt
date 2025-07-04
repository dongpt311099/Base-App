package loan.personal.quickloan.utils.loan.tools

data class DiscountData(val priceAfterDiscount: Double, val youSaved: Double, val discountPercent: Float)
enum class DiscountType { Percent, Fixed }

class DiscountCalculator {
    var priceBefore: Double = 0.0
    var discount: Double = 0.0
    var type: DiscountType = DiscountType.Percent

    fun calcDiscountPercentOffCalculator(): DiscountData {
        if(discount <= 0f) throw IllegalArgumentException("Discount rate can not be negative")

        return when(type){
            DiscountType.Percent -> {
                val priceAfterDiscount = priceBefore - (discount/100) * priceBefore
                val youSaved = priceBefore - priceAfterDiscount
                DiscountData(priceAfterDiscount = priceAfterDiscount, youSaved = youSaved, discountPercent = discount.toFloat())
            }

            DiscountType.Fixed -> {
                val priceAfterDiscount = priceBefore - discount
                DiscountData(priceAfterDiscount = priceAfterDiscount, youSaved = discount, discountPercent = (discount*100/priceBefore).toFloat())
            }
        }
    }
}