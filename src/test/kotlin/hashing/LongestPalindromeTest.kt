package hashing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.hashing.LongestPalindrome

class LongestPalindromeTest {
    @TestFactory
    fun findLongestPalindrome() = listOf(
        "applepie" to 5,
        "aabbcc" to 6,
        "bananas" to 5,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Find longest palindrome length in '$input'") {
            val output = LongestPalindrome.find(input)
            Assertions.assertEquals(expected, output)
        }
    }
}