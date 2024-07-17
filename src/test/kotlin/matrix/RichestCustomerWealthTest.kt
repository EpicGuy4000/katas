package matrix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.matrix.RichestCustomerWealth

class RichestCustomerWealthTest {
    @TestFactory
    fun runningSum() = listOf(
        arrayOf(arrayOf(5, 2, 3), arrayOf(0, 6, 7)) to 13,
        arrayOf(arrayOf(1, 2), arrayOf(3, 4), arrayOf(5, 6)) to 11,
        arrayOf(arrayOf(10, 100), arrayOf(200, 20), arrayOf(30, 300)) to 330,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Richest customer wealth for $input") {
            assertEquals(expected, RichestCustomerWealth.getMostWealth(input))
        }
    }
}