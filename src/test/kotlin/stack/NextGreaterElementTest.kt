package stack

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.stack.NextGreaterElement

class NextGreaterElementTest {
    @TestFactory
    fun getNges() = listOf(
        arrayOf(4, 5, 2, 25) to arrayOf(5, 25, 25, -1),
        arrayOf(13, 7, 6, 12) to arrayOf(-1, 12, 12, -1),
        arrayOf(1, 2, 3, 4, 5) to arrayOf(2, 3, 4, 5, -1),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Checks if $input has nges calculated correctly") {
            assertArrayEquals(expected, NextGreaterElement.getNges(input))
        }
    }
}