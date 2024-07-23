package hashing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.hashing.LongestSubstringWithoutRepeatingCharacters

class LongestSubstringWithoutRepeatingCharactersTest {
    @TestFactory
    fun findLongestSubstringWithoutRepeatingCharacters() = listOf(
        "abcdaef" to 6,
        "aaaaa" to 1,
        "abrkaabcdefghijjxxx" to 10,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Find length of longest substring without repeating characters in '${input}'") {
            val output = LongestSubstringWithoutRepeatingCharacters.find(input)
            Assertions.assertEquals(expected, output)
        }
    }
}