package org.kata.price_calculator

import kotlin.math.min

class PercentageCap(private val cap: Double) : DiscountCap {
    override fun applyCap(startingPrice: Money, discountAmount: Money): Money =
        Money(min((startingPrice * (Money(cap / 100.0))).getAmount(), discountAmount.getAmount()))

}

