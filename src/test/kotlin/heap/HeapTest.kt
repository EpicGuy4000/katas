package heap

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.heap.Heap

class HeapTest {
    @TestFactory
    fun heapify() = listOf(
        listOf(4, 3, 1, 5, 6) to listOf(1, 3, 4, 5, 6),
        listOf(7, 8, 9, 10) to listOf(7, 8, 9, 10),
        listOf(11, 13, -1, 6) to listOf(-1, 6, 11, 13),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Test if elements of '${input}' are returned in order from min to max") {
            val output = Heap(input) { it }.let {
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

    @TestFactory
    fun insert() = listOf(
        Pair(listOf(4, 3, 1, 5, 6), 2) to Pair(1, listOf(1, 2, 3, 4, 5, 6)),
        Pair(listOf(7, 8, 9, 10), 6) to Pair(7, listOf(6, 7, 8, 9, 10)),
        Pair(listOf(11, 13, -1, 6), 0) to Pair(-1, listOf(-1, 0, 6, 11, 13)),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Test if elements of '${input.first}' are returned in order from min to max after inserting ${input.second}") {
            val output = Heap(input.first) { it }.also {
                Assertions.assertEquals(expected.first, it.peekTop())
            }.apply {
                insert(input.second)
            }.let {
                var top = it.removeTop()
                val outputBuilder = mutableListOf<Int>()

                while (top != null) {
                    outputBuilder.add(top)
                    top = it.removeTop()
                }

                outputBuilder
            }

            Assertions.assertArrayEquals(expected.second.toTypedArray(), output.toTypedArray())
        }
    }
}