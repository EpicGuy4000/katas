package org.kata.price_calculator

import org.junit.jupiter.api.Assertions.*
import org.kata.org.kata.price_calculator.*
import kotlin.test.Test
import kotlin.test.assertContains

class RegisterTest {
    @Test
    fun tax_case1() {
        val product = Product("The Little Prince", 12345, Money(20.25))

        val receipt = Register(product, 20.0).getReceipt()
        assertEquals(20.25, receipt.cost)
        assertEquals(24.30, receipt.total)
    }

    @Test
    fun tax_case2() {
        val product = Product("The Little Prince", 12345, Money(20.25))

        val receipt = Register(product, 21.0).getReceipt()
        assertEquals(20.25, receipt.cost)
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
        assertEquals(20.25, receipt.cost)
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

        assertContains(printed, "TOTAL: $21.26")
        assertContains(printed, "DISCOUNT: $3.04")
    }

    @Test
    fun report_case2() {
        val product = Product("The Little Prince", 12345, Money(20.25))

        val receipt = Register(product, 20.0).getReceipt()

        val printed = receipt.print()

        assertContains(printed, "TOTAL: $24.30")
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

        assertEquals(20.25, receipt.cost)
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

        assertEquals(20.25, receipt.cost)
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

        assertEquals(20.25, receipt.cost)
        assertEquals(3.77, receipt.taxAmount)
        assertEquals(4.24, receipt.discountAmount)
        assertEquals(19.78, receipt.total)
    }

    @Test
    fun expenses_case1() {
        val product = Product("The Little Prince", 12345, Money(20.25))

        val receipt = Register(product, 21.0).apply {
            discounts.apply {
                add(UniversalDiscount(15.0, DiscountApplicability.AFTER_TAX))
                add(UpcDiscount(7.0, 12345, DiscountApplicability.AFTER_TAX))
            }
            expenses.apply {
                add(PercentageExpense("Packaging", 1.0))
                add(FlatExpense("Transport", 2.2))
            }
        }.getReceipt()

        assertEquals(20.25, receipt.cost)
        assertEquals(4.25, receipt.taxAmount)
        assertEquals(4.46, receipt.discountAmount)
        assertEquals(0.20, receipt.expenses["Packaging"])
        assertEquals(2.20, receipt.expenses["Transport"])
        assertEquals(22.44, receipt.total)
    }

    @Test
    fun expenses_case1_print() {
        val product = Product("The Little Prince", 12345, Money(20.25))

        val receipt = Register(product, 21.0).apply {
            discounts.apply {
                add(UniversalDiscount(15.0, DiscountApplicability.AFTER_TAX))
                add(UpcDiscount(7.0, 12345, DiscountApplicability.AFTER_TAX))
            }
            expenses.apply {
                add(PercentageExpense("Packaging", 1.0))
                add(FlatExpense("Transport", 2.2))
            }
        }.getReceipt().print()

        assertContains(receipt, "COST: $20.25")
        assertContains(receipt, "TAX: $4.25")
        assertContains(receipt, "DISCOUNT: $4.46")
        assertContains(receipt, "Packaging: $0.20")
        assertContains(receipt, "Transport: $2.20")
        assertContains(receipt, "TOTAL: $22.44")
    }

    @Test
    fun expenses_case2() {
        val product = Product("The Little Prince", 12345, Money(20.25))

        val receipt = Register(product, 21.0).getReceipt()

        assertEquals(20.25, receipt.cost)
        assertEquals(4.25, receipt.taxAmount)
        assertEquals(24.5, receipt.total)
    }

    @Test
    fun combining_case1() {
        val product = Product("The Little Prince", 12345, Money(20.25))

        val receipt = Register(product, 21.0, DiscountCombining.ADDITIVE).apply {
            discounts.apply {
                add(UniversalDiscount(15.0, DiscountApplicability.AFTER_TAX))
                add(UpcDiscount(7.0, 12345, DiscountApplicability.AFTER_TAX))
            }
            expenses.apply {
                add(PercentageExpense("Packaging", 1.0))
                add(FlatExpense("Transport", 2.2))
            }
        }.getReceipt()

        assertEquals(20.25, receipt.cost)
        assertEquals(4.25, receipt.taxAmount)
        assertEquals(4.46, receipt.discountAmount)
        assertEquals(0.20, receipt.expenses["Packaging"])
        assertEquals(2.20, receipt.expenses["Transport"])
        assertEquals(22.44, receipt.total)
    }

    @Test
    fun combining_case2() {
        val product = Product("The Little Prince", 12345, Money(20.25))

        val receipt = Register(product, 21.0, DiscountCombining.MULTIPLICATIVE).apply {
            discounts.apply {
                add(UniversalDiscount(15.0, DiscountApplicability.AFTER_TAX))
                add(UpcDiscount(7.0, 12345, DiscountApplicability.AFTER_TAX))
            }
            expenses.apply {
                add(PercentageExpense("Packaging", 1.0))
                add(FlatExpense("Transport", 2.2))
            }
        }.getReceipt()

        assertEquals(20.25, receipt.cost)
        assertEquals(4.25, receipt.taxAmount)
        assertEquals(4.24, receipt.discountAmount)
        assertEquals(0.20, receipt.expenses["Packaging"])
        assertEquals(2.20, receipt.expenses["Transport"])
        assertEquals(22.66, receipt.total)
    }
}