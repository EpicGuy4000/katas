package hashing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.hashing.JewelsAndStones

class JewelsAndStonesTest {
    @TestFactory
    fun countJewels() = listOf(
        Pair("abc", "aabbcc") to 6,
        Pair("aA", "aAaZz") to 3,
        Pair("zZ", "zZzZzZ") to 6,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Counts jewels in '${input.second}' where jewels are defined as '${input.first}'") {
            val output = JewelsAndStones.countJewels(input.first, input.second)
            Assertions.assertEquals(expected, output)
        }
    }
}