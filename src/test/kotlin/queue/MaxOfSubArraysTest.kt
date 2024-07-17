package queue

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.queue.MaxOfSubArrays

class MaxOfSubArraysTest {
    @TestFactory
    fun reverse() = listOf(
        Pair(listOf(1, 2, 3, 1, 4, 5, 2, 3, 6), 3) to listOf(3, 3, 4, 5, 5, 5, 6),
        Pair(listOf(8, 5, 10, 7, 9, 4, 15, 12, 90, 13), 4) to listOf(10, 10, 10, 15, 15, 90, 90),
        Pair(listOf(1, 2, 3, 4, 5), 3) to listOf(3, 4, 5),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Finds max of subArrays of $input") {
            assertArrayEquals(expected.toTypedArray(), MaxOfSubArrays.findMax(input.first, input.second).toTypedArray())
        }
    }
}