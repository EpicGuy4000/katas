package stack

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.stack.RemovingStars

class RemovingStarsTest {
    @TestFactory
    fun reverse() = listOf(
        "abc*de*f" to "abdf",
        "a*b*c*d" to "d",
        "abcd" to "abcd",
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Removes stars from $input") {
            assertEquals(expected, RemovingStars.removeStars(input))
        }
    }
}