package org.kata.price_calculator

class Receipt(private val moneyFormatter: MoneyFormatter) {
    private fun printMoney(number: Double) = moneyFormatter.format(number)

    fun print(): String {
        return "COST: ${printMoney(cost)}" +
                (if (taxAmount != 0.0) "\nTAX: ${printMoney(taxAmount)}" else "") +
                (if (discountAmount != 0.0) "\nDISCOUNT: ${printMoney(discountAmount)}" else "") +
                (expenses.map { "\n${it.key}: ${printMoney(it.value)}" }.joinToString("")) +
                "\nTOTAL: ${printMoney(total)}"
    }

    val expenses: MutableMap<String, Double> = mutableMapOf()
    var discountAmount: Double = 0.0
    var taxAmount: Double = 0.0
    var cost: Double = 0.0
    var total: Double = 0.0
}
