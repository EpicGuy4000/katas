package org.kata.price_calculator

import org.junit.jupiter.api.Assertions.*
import org.kata.org.kata.price_calculator.*
import kotlin.test.Test

class RegisterTest {
    @Test
    fun tax_case1() {
        val product = Product("The Little Prince", 12345, Money(20.25))

        val receipt = Register(product, 20.0).getReceipt()
        assertEquals(20.25, receipt.price)
        assertEquals(24.30, receipt.total)
    }

    @Test
    fun tax_case2() {
        val product = Product("The Little Prince", 12345, Money(20.25))

        val receipt = Register(product, 21.0).getReceipt()
        assertEquals(20.25, receipt.price)
        assertEquals(24.50, receipt.total)
    }

    @Test
    fun discount() {
        val product = Product("The Little Prince", 12345, Money(20.25))

        val receipt = Register(product, 20.0).apply {
            discounts.apply {
                add(UniversalDiscount(15.0, DiscountApplicability.AFTER_TAX))
            }
        }.getReceipt()
        assertEquals(4.05, receipt.taxAmount)
        assertEquals(3.04, receipt.discountAmount)
        assertEquals(20.25, receipt.price)
        assertEquals(21.26, receipt.total)
    }

    @Test
    fun report_case1() {
        val product = Product("The Little Prince", 12345, Money(20.25))

        val receipt = Register(product, 20.0).apply {
            discounts.apply {
                add(UniversalDiscount(15.0, DiscountApplicability.AFTER_TAX))
            }
        }.getReceipt()

        val printed = receipt.print()

        assertEquals("TOTAL: $21.26\n" +
                "DISCOUNT: $3.04", printed)
    }

    @Test
    fun report_case2() {
        val product = Product("The Little Prince", 12345, Money(20.25))

        val receipt = Register(product, 20.0).getReceipt()

        val printed = receipt.print()

        assertEquals("TOTAL: $24.30", printed)
    }

    @Test
    fun selective_case1() {
        val product = Product("The Little Prince", 12345, Money(20.25))

        val receipt = Register(product, 20.0).apply {
            discounts.apply {
                add(UniversalDiscount(15.0, DiscountApplicability.AFTER_TAX))
                add(UpcDiscount(7.0, 12345, DiscountApplicability.AFTER_TAX))
            }
        }.getReceipt()

        assertEquals(20.25, receipt.price)
        assertEquals(4.05, receipt.taxAmount)
        assertEquals(4.46, receipt.discountAmount)
        assertEquals(19.84, receipt.total)
    }

    @Test
    fun selective_case2() {
        val product = Product("The Little Prince", 12345, Money(20.25))

        val receipt = Register(product, 21.0).apply {
            discounts.apply {
                add(UniversalDiscount(15.0, DiscountApplicability.AFTER_TAX))
                add(UpcDiscount(7.0, 789, DiscountApplicability.AFTER_TAX))
            }
        }.getReceipt()

        assertEquals(20.25, receipt.price)
        assertEquals(4.25, receipt.taxAmount)
        assertEquals(3.04, receipt.discountAmount)
        assertEquals(21.46, receipt.total)
    }

    @Test
    fun precedence() {
        val product = Product("The Little Prince", 12345, Money(20.25))

        val receipt = Register(product, 20.0).apply {
            discounts.apply {
                add(UniversalDiscount(15.0, DiscountApplicability.AFTER_TAX))
                add(UpcDiscount(7.0, 12345, DiscountApplicability.BEFORE_TAX))
            }
        }.getReceipt()

        assertEquals(20.25, receipt.price)
        assertEquals(3.77, receipt.taxAmount)
        assertEquals(4.24, receipt.discountAmount)
        assertEquals(19.78, receipt.total)
    }
}