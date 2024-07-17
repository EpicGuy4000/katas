package queue

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.queue.BinaryNumberGenerator

class BinaryNumberGeneratorTest {
    @TestFactory
    fun reverse() = listOf(
        2 to listOf("1", "10"),
        3 to listOf("1", "10", "11"),
        5 to listOf("1", "10", "11", "100", "101"),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Checks if first $input numbers are generated correctly") {
            assertEquals(expected, BinaryNumberGenerator.generate(input))
        }
    }
}