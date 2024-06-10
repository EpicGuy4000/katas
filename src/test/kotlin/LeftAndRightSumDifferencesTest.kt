import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.LeftAndRightSumDifferences

class LeftAndRightSumDifferencesTest {
    @TestFactory
    fun runningSum() = listOf(
        listOf(2, 5, 1, 6) to arrayOf(12, 5, 1, 8),
        listOf(3, 3, 3) to arrayOf(6, 0, 6),
        listOf(1, 2, 3, 4, 5) to arrayOf(14, 11, 6, 1, 10)
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Calculates running sum of $input") {
            assertArrayEquals(expected, LeftAndRightSumDifferences.getDifferenceArray(input))
        }
    }
}