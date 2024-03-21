package org.kata.price_calculator

class Register(private val product: Product, private val taxPercentage: Double, private val discountPercentage: Double = 0.0) {
    fun getReceipt(): Receipt {
        return Receipt().apply {
            price = product.price.getAmount()
            taxAmount = (product.price * Money(taxPercentage / 100.0)).getAmount()
            discountAmount = (product.price * Money(discountPercentage / 100.00)).getAmount()
            total = (product.price + taxAmount - discountAmount).getAmount()
        }
    }
}