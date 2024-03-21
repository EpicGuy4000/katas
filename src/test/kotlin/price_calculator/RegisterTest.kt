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
    fun taxIs20Percent() {
        val product = Product("The Little Prince", 12345, Money(20.25))

        val receipt = Register(product, 20.0).getReceipt()
        assertEquals(20.25, receipt.priceBeforeTax)
        assertEquals(24.30, receipt.priceAfterTax)
    }

    @Test
    fun taxIs21Percent() {
        val product = Product("The Little Prince", 12345, Money(20.25))

        val receipt = Register(product, 21.0).getReceipt()
        assertEquals(20.25, receipt.priceBeforeTax)
        assertEquals(24.50, receipt.priceAfterTax)
    }
}