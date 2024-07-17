package queue

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.queue.ReverseQueue
import java.util.*

class ReverseQueueTest {
    @TestFactory
    fun reverse() = listOf(
        LinkedList(arrayListOf(1, 2, 3, 4, 5)) to arrayOf(5, 4, 3, 2, 1),
        LinkedList(arrayListOf(10, 20, 30, 40, 50)) to arrayOf(50, 40, 30, 20, 10),
        LinkedList(arrayListOf(5, 7, 9)) to arrayOf(9, 7, 5),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Checks if $input is reversed correctly") {
            assertArrayEquals(expected, ReverseQueue.reverse(input).toTypedArray())
        }
    }
}