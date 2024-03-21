package org.kata.price_calculator

class Register(private val product: Product, private val taxPercentage: Double) {
    var upc: Int = 0
    var upcDiscountPercentage: Double = 0.0
    var discountPercentage: Double = 0.0

    fun getReceipt(): Receipt {
        return Receipt().apply {
            price = product.price.getAmount()
            taxAmount = (product.price * Money(taxPercentage / 100.0)).getAmount()
            val universalDiscount = product.price * Money(discountPercentage / 100.00)
            val selectiveDiscount = if (upc == product.upc) product.price * Money(upcDiscountPercentage / 100.00) else Money(0.0)

            discountAmount = (universalDiscount + selectiveDiscount).getAmount()
            total = (product.price + taxAmount - discountAmount).getAmount()
        }
    }
}