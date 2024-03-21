package org.kata.org.kata.price_calculator

class Receipt {
    companion object {
        fun printNumber(number: Double) = "%.2f".format(number)
    }

    fun print(): String {
        return "TOTAL: \$${printNumber(total)}" +
                if (discountAmount != 0.0) "\nDISCOUNT: \$${printNumber(discountAmount)}" else ""
    }

    var discountAmount: Double = 0.0
    var taxAmount: Double = 0.0
    var price: Double = 0.0
    var total: Double = 0.0
}
