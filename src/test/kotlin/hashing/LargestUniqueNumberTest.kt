package hashing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.hashing.LargestUniqueNumber

class LargestUniqueNumberTest {
    @TestFactory
    fun findLargestUniqueNumber() = listOf(
        listOf(5, 7, 3, 7, 5, 8) to 8,
        listOf(1, 2, 3, 2, 1, 4, 4) to 3,
        listOf(9, 9, 8, 8, 7, 7) to -1,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Finds largest unique number of '$input'") {
            val output = LargestUniqueNumber.find(input)
            Assertions.assertEquals(expected, output)
        }
    }
}