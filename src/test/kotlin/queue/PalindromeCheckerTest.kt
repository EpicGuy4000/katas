package queue

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.queue.PalindromeChecker

class PalindromeCheckerTest {
    @TestFactory
    fun reverse() = listOf(
        "madam" to true,
        "openai" to false,
        "A man a plan a canal Panama" to true,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Checks if $input is a palindrome") {
            assertEquals(expected, PalindromeChecker.check(input))
        }
    }
}