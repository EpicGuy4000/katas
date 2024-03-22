package org.kata.price_calculator

interface Discount {
    fun applyTo(product: Product, priceToApplyOn: Money): Money

    val applicability: DiscountApplicability
}
