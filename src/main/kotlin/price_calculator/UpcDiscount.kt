package org.kata.price_calculator

class UpcDiscount(private val percentage: Double, private val upc: Int, override val applicability: DiscountApplicability) :
    Discount {
    override fun applyTo(product: Product, priceToApplyOn: Money): Money =
        if (upc == product.upc) priceToApplyOn * Money(percentage / 100.00)
        else Money(0.0)
}
