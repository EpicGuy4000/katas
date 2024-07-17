package stack

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.stack.MakeStringGreat

class MakeStringGreatTest {
    @TestFactory
    fun sortStack() = listOf(
        "AaBbCcDdEeff" to "ff",
        "abBA" to "",
        "s" to "s",
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Makes $input great") {
            val output = MakeStringGreat.makeGreat(input)
            assertEquals(expected, output)
        }
    }
}