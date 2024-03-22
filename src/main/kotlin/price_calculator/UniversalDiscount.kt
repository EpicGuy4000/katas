package org.kata.price_calculator

class UniversalDiscount(private val percentage: Double, override val applicability: DiscountApplicability) : Discount {
    override fun applyTo(product: Product, priceToApplyOn: Money): Money = priceToApplyOn * Money(percentage / 100.00)
}
