package org.kata.org.kata.price_calculator

import org.kata.price_calculator.Expense
import org.kata.price_calculator.Money

class Register(private val product: Product, private val taxPercentage: Double) {
    val discounts: MutableList<Discount> = mutableListOf()
    val expenses: MutableList<Expense> = mutableListOf()

    fun getReceipt(): Receipt {
        val register = this

        return Receipt().apply {
            cost = product.price.getAmount()

            val discountAmountBeforeTax = Money(discounts.filter { it.applicability == DiscountApplicability.BEFORE_TAX }
                .sumOf { it.applyTo(product, product.price).getAmount() })

            val priceAfterPreTaxDiscount = product.price - discountAmountBeforeTax

            taxAmount = (priceAfterPreTaxDiscount * Money(taxPercentage / 100.0)).getAmount()

            val discountAmountAfterTax = Money(discounts.filter { it.applicability == DiscountApplicability.AFTER_TAX }
                .sumOf { it.applyTo(product, priceAfterPreTaxDiscount).getAmount() })

            discountAmount = (discountAmountBeforeTax + discountAmountAfterTax).getAmount()
            expenses.apply {
                for (expense in register.expenses) {
                    put(expense.name, expense.getAmount(product.price))
                }
            }

            total = (product.price + taxAmount + expenses.values.sum() - discountAmount).getAmount()
        }
    }
}