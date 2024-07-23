package hashing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.hashing.UniqueNumberOfOccurrences

class UniqueNumberOfOccurrencesTest {
    @TestFactory
    fun countOneUps() = listOf(
        listOf(4, 5, 4, 6, 6, 6) to true,
        listOf(7, 8, 8, 9, 9, 9, 10, 10) to false,
        listOf(11, 12, 13, 14, 14, 15, 15, 15) to false,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Checks if the numbers of occurrences of each element in'${input}' are unique") {
            val output = UniqueNumberOfOccurrences.checkIfCountsAreUnique(input)
            Assertions.assertEquals(expected, output)
        }
    }
}