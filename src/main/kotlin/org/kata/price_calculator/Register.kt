package org.kata.org.kata.price_calculator

import org.kata.price_calculator.Money

class Register(private val product: Product, private val taxPercentage: Double) {
    val discounts: MutableList<Discount> = mutableListOf()

    fun getReceipt(): Receipt {
        return Receipt().apply {
            price = product.price.getAmount()

            val discountAmountBeforeTax = Money(discounts.filter { it.applicability == DiscountApplicability.BEFORE_TAX }
                .sumOf { it.applyTo(product, product.price).getAmount() })

            val priceAfterPreTaxDiscount = product.price - discountAmountBeforeTax

            taxAmount = (priceAfterPreTaxDiscount * Money(taxPercentage / 100.0)).getAmount()

            val discountAmountAfterTax = Money(discounts.filter { it.applicability == DiscountApplicability.AFTER_TAX }
                .sumOf { it.applyTo(product, priceAfterPreTaxDiscount).getAmount() })

            discountAmount = (discountAmountBeforeTax + discountAmountAfterTax).getAmount()
            total = (product.price + taxAmount - discountAmount).getAmount()
        }
    }
}