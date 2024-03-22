package org.kata.price_calculator

class PercentageExpense(override val name: String, private val percentage: Double) : Expense {
    override fun getAmount(priceToApplyTo: Money): Double = (priceToApplyTo * Money(percentage / 100.0)).getAmount()
}