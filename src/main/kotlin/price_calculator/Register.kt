package org.kata.price_calculator

class Register(private val product: Product, private val taxPercentage: Double) {
    fun getReceipt(): Receipt {
        return Receipt().apply {
            priceBeforeTax = product.price.getAmount()
            priceAfterTax = (product.price * Money((100 + taxPercentage) / 100.0)).getAmount()
        }
    }
}