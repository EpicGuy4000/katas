package stack

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.stack.DecimalToBinaryConversion

class DecimalToBinaryConversionTest {
    @TestFactory
    fun convertToBinary() = listOf(
        2 to "10",
        7 to "111",
        18 to "10010",
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Checks if $input is converted correctly") {
            Assertions.assertEquals(expected, DecimalToBinaryConversion.convert(input))
        }
    }
}