package org.kata.org.kata.price_calculator

import org.kata.price_calculator.Expense
import org.kata.price_calculator.Money

class Register(
    private val product: Product,
    private val taxPercentage: Double,
    private val combining: DiscountCombining = DiscountCombining.ADDITIVE
) {
    val discounts: MutableList<Discount> = mutableListOf()
    val expenses: MutableList<Expense> = mutableListOf()

    fun getReceipt(): Receipt {
        val register = this

        return Receipt().apply {
            cost = product.price.getAmount()

            val discountAmountBeforeTax = applyDiscounts(product.price, discounts.filter { it.applicability == DiscountApplicability.BEFORE_TAX })

            val priceAfterPreTaxDiscount = product.price - discountAmountBeforeTax

            taxAmount = (priceAfterPreTaxDiscount * Money(taxPercentage / 100.0)).getAmount()

            val discountAmountAfterTax = applyDiscounts(priceAfterPreTaxDiscount, discounts.filter { it.applicability == DiscountApplicability.AFTER_TAX })

            discountAmount = (discountAmountBeforeTax + discountAmountAfterTax).getAmount()
            expenses.apply {
                for (expense in register.expenses) {
                    put(expense.name, expense.getAmount(product.price))
                }
            }

            total = (product.price + taxAmount + expenses.values.sum() - discountAmount).getAmount()
        }
    }

    private fun applyDiscounts(startingPrice: Money, discountsToApply: Iterable<Discount>): Money =
        startingPrice - discountsToApply.fold(startingPrice) { acc, discount ->
                acc - discount.applyTo(product, if (combining == DiscountCombining.ADDITIVE) startingPrice else acc)
            }
}