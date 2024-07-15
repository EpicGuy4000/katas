import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.QueueStack

class QueueStackTest {
    @TestFactory
    fun stackWorksAsExpected() = listOf(
        Pair(arrayOf(1, 2, 3), 2) to arrayOf(1),
        Pair(arrayOf(9, 8), 1) to arrayOf(9),
        Pair(arrayOf(5, 6, 7, 8), 4) to emptyArray(),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Checks if QueueStack functions correctly") {
            val stack = QueueStack<Int>()

            for (pushOperation in input.first) {
                stack.push(pushOperation)
            }

            repeat (input.second) {
                stack.pop()
            }

            val endStackState = buildList {
                while (!stack.isEmpty()) {
                    add(stack.pop())
                }
            }

            assertArrayEquals(expected, endStackState.toTypedArray())
        }
    }
}