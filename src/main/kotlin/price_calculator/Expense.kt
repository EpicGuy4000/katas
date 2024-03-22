package org.kata.price_calculator

interface Expense {
    val name: String
    fun getAmount(priceToApplyTo: Money): Double
}