package org.kata.price_calculator

class DefaultMoneyFormatter : MoneyFormatter {
    override fun format(money: Double): String = "\$%.2f".format(money)
}

