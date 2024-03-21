package org.kata.org.kata.price_calculator

import org.kata.price_calculator.Money

class UniversalDiscount(private val percentage: Double, override val applicability: DiscountApplicability) : Discount {
    override fun applyTo(product: Product, priceToApplyOn: Money): Money = priceToApplyOn * Money(percentage / 100.00)
}
