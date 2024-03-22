package org.kata.price_calculator

import kotlin.math.min

class FlatCap(private val cap: Double): DiscountCap {
    override fun applyCap(startingPrice: Money, discountAmount: Money): Money =
        Money(min(cap, discountAmount.getAmount()))
}