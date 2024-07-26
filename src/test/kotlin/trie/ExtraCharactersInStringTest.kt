package trie

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.trie.ExtraCharactersInString

class ExtraCharactersInStringTest {
    @TestFactory
    fun minExtraChar() = listOf(
        Pair("amazingracecar", listOf("race", "car")) to 7,
        Pair("bookkeeperreading", listOf("keep", "read")) to 9,
        Pair("thedogbarksatnight", listOf("dog", "bark", "night")) to 6,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Find minimum count of remaining characters in '${input.first}' after using '${input.second}' to be $expected") {
            val output = ExtraCharactersInString.find(input.first, input.second)
            Assertions.assertEquals(expected, output)
        }
    }
}