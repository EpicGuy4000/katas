package heap

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.heap.MinHeap

class MinHeapTest {
    @TestFactory
    fun heapify() = listOf(
        listOf(4, 3, 1, 5, 6) to listOf(1, 3, 4, 5, 6),
        listOf(7, 8, 9, 10) to listOf(7, 8, 9, 10),
        listOf(11, 13, -1, 6) to listOf(-1, 6, 11, 13),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Test if elements of '${input}' are returned in order from min to max") {
            val output = MinHeap(input).let {
                var top = it.removeTop()
                val outputBuilder = mutableListOf<Int>()

                while (top != null) {
                    outputBuilder.add(top)
                    top = it.removeTop()
                }

                outputBuilder
            }

            Assertions.assertArrayEquals(expected.toTypedArray(), output.toTypedArray())
        }
    }
}