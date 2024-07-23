package hashing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.hashing.RansomNote

class RansomNoteTest {
    @TestFactory
    fun isRansomNoteCreatable() = listOf(
        Pair("hello", "hellworld") to true,
        Pair("notes", "stoned") to true,
        Pair("apple", "pale") to false,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Find if ransom note '${input.first}' can be created from magazine ${input.second}") {
            val output = RansomNote.findIfPossible(input.first, input.second)
            Assertions.assertEquals(expected, output)
        }
    }
}