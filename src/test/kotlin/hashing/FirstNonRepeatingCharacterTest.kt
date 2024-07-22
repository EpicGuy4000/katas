package hashing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.hashing.FirstNonRepeatingCharacter

class FirstNonRepeatingCharacterTest {
    @TestFactory
    fun findFirstNonRepeatingCharacter() = listOf(
        "apple" to 0,
        "abcab" to 2,
        "abab" to -1
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Finds first non-repeating character of '$input'") {
            val output = FirstNonRepeatingCharacter.find(input)
            Assertions.assertEquals(expected, output)
        }
    }
}