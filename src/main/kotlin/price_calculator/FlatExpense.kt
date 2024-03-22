package org.kata.price_calculator

class FlatExpense(override val name: String, private val amount: Double) : Expense {
    override fun getAmount(priceToApplyTo: Money): Double = amount
}