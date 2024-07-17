package matrix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.matrix.MatrixDiagonalSum

class MatrixDiagonalSumTest {
    @TestFactory
    fun runningSum() = listOf(
        arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6), arrayOf(7, 8, 9)) to 25,
        arrayOf(arrayOf(1, 0), arrayOf(0, 1)) to 2,
        arrayOf(arrayOf(5)) to 5,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Matrix diagonal sum of $input") {
            assertEquals(expected, MatrixDiagonalSum.getDiagonalSum(input))
        }
    }
}