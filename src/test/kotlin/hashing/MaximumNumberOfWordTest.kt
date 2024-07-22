package hashing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.hashing.MaximumNumberOfWord

class MaximumNumberOfWordTest {
    @TestFactory
    fun findMaximumNumberOfBalloons() = listOf(
        "balloonballoon" to 2,
        "bbaall" to 0,
        "balloonballoooon" to 2,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Find maximum number of balloons in '$input'") {
            val output = MaximumNumberOfWord("balloon").find(input)
            Assertions.assertEquals(expected, output)
        }
    }
}