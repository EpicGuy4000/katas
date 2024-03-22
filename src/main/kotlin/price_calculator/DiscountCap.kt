package org.kata.price_calculator

interface DiscountCap {
    fun applyCap(startingPrice: Money, discountAmount: Money): Money
}

