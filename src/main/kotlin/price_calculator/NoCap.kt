package org.kata.price_calculator

class NoCap : DiscountCap {
    override fun applyCap(startingPrice: Money, discountAmount: Money): Money = discountAmount
}
