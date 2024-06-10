import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.SumConsecutiveNumbers

class SumConsecutiveNumbersTest {
    @TestFactory
    fun sum() = listOf(
        listOf(1, 4, 4, 4, 0, 4, 3, 3, 1) to listOf(1, 12, 0, 4, 6, 1),
        listOf(1, 1, 7, 7, 3) to listOf(2, 14, 3),
        listOf(-5, -5, 7, 7, 12, 0) to listOf(-10, 14, 12, 0),
        listOf(3, 3, 3, 3, 1) to listOf(12, 1)
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Sums consecutive numbers in $input") {
            assertEquals(expected, SumConsecutiveNumbers.sum(input))
        }
    }
}