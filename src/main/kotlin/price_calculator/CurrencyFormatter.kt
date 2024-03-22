package org.kata.price_calculator

class CurrencyFormatter(private val currency: String) : MoneyFormatter {
    override fun format(money: Double): String = "%.2f $currency".format(money)
}