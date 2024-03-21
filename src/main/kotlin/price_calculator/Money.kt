package org.kata.price_calculator

import java.math.BigDecimal
import java.math.RoundingMode

class Money {
    public val amount: BigDecimal;
    public fun getAmount(): Double = amount.setScale(2, RoundingMode.HALF_EVEN).toDouble()
    constructor(amount: Double) {
        this.amount = amount.toBigDecimal()
    }
    constructor(amount: BigDecimal) {
        this.amount = amount
    }

    operator fun times(other: Money): Money = Money(amount * other.amount)
    operator fun div(other: Money): Money = Money(amount / other.amount)
    operator fun minus(other: Money): Money = Money(amount - other.amount)
    operator fun plus(other: Money): Money = Money(amount + other.amount)
}
