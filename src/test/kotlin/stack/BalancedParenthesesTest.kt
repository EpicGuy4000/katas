package stack

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.stack.BalancedParentheses

class BalancedParenthesesTest {
    @TestFactory
    fun isBalanced() = listOf(
        "{[()]}" to true,
        "{[}]" to false,
        "(]" to false,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Checks if $input is balanced") {
            assertEquals(expected, BalancedParentheses.isBalanced(input))
        }
    }
}