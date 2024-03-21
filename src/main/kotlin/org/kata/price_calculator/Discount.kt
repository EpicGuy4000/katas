package org.kata.org.kata.price_calculator

import org.kata.price_calculator.Money

interface Discount {
    fun applyTo(product: Product, priceToApplyOn: Money): Money

    val applicability: DiscountApplicability
}
