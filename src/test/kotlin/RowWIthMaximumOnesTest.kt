import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.RowWithMaximumOnes

class RowWIthMaximumOnesTest {
    @TestFactory
    fun runningSum() = listOf(
        arrayOf(arrayOf(1, 0), arrayOf(1, 1), arrayOf(0, 1)) to Pair(1, 2),
        arrayOf(arrayOf(0, 1, 1), arrayOf(0, 1, 1), arrayOf(1, 1, 1)) to Pair(2, 3),
        arrayOf(arrayOf(1, 0, 1), arrayOf(0, 0, 1), arrayOf(1, 1, 0)) to Pair(0, 2),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Most ones in a row for $input") {
            assertEquals(expected, RowWithMaximumOnes.getMostOnes(input))
        }
    }
}