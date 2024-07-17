package stack

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.stack.SortingStack
import java.util.*

class SortingStackTest {
    @TestFactory
    fun sortStack() = listOf(
        Stack<Int>().apply {
            push(34)
            push(3)
            push(31)
            push(98)
            push(92)
            push(23)
        } to arrayOf(3, 23, 31, 34, 92, 98),
        Stack<Int>().apply {
            push(4)
            push(3)
            push(2)
            push(10)
            push(12)
            push(1)
            push(5)
            push(6)
        } to arrayOf(1, 2, 3, 4, 5, 6, 10, 12),
        Stack<Int>().apply {
            push(20)
            push(10)
            push(-5)
            push(-1)
        } to arrayOf(-5, -1, 10, 20),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Checks if $input is sorted to [${expected.joinToString(" ")}]") {
            val output = SortingStack.sort(input)
            assertArrayEquals(expected, output.toArray())
        }
    }
}