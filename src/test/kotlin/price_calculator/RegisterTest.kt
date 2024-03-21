package price_calculator

import org.kata.price_calculator.Product
import org.kata.price_calculator.Register
import org.junit.jupiter.api.BeforeEach
import org.kata.price_calculator.Money

import kotlin.test.Test
import kotlin.test.assertEquals

class RegisterTest {
    @BeforeEach
    fun setUp() {
    }

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
            discountPercentage = 15.0
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
            discountPercentage = 15.0
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
            discountPercentage = 15.0
            upcDiscountPercentage = 7.0
            upc = 12345
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
            discountPercentage = 15.0
            upcDiscountPercentage = 7.0
            upc = 789
        }.getReceipt()

        assertEquals(20.25, receipt.price)
        assertEquals(4.25, receipt.taxAmount)
        assertEquals(3.04, receipt.discountAmount)
        assertEquals(21.46, receipt.total)
    }
}