package hashing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.hashing.CountingElements

class CountingElementsTest {
    @TestFactory
    fun countOneUps() = listOf(
        listOf(4, 3, 1, 5, 6) to 3,
        listOf(7, 8, 9, 10) to 3,
        listOf(11, 13, 15, 16) to 1,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Counts elements of '${input}' where n + 1 exists") {
            val output = CountingElements.countWhereOneUpExists(input)
            Assertions.assertEquals(expected, output)
        }
    }
}