package array

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.array.RunningSumOf1DArray

class RunningSumOf1DArrayTest {
    @TestFactory
    fun runningSum() = listOf(
        listOf(2, 3, 5, 1, 6) to listOf(2, 5, 10, 11, 17),
        listOf(1, 1, 1, 1, 1) to listOf(1, 2, 3, 4, 5),
        listOf(-1, 2, -3, 4, -5) to listOf(-1, 1, -2, 2, -3)
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Calculates running sum of $input") {
            assertEquals(expected, RunningSumOf1DArray.runningSum(input))
        }
    }
}