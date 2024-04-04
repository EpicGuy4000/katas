import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.MultiplicationTable

class MultiplicationTableTest {
    @TestFactory
    fun convert() = listOf(
        1 to arrayOf(intArrayOf(1)),
        2 to arrayOf(intArrayOf(1, 2), intArrayOf(2, 4)),
        3 to arrayOf(intArrayOf(1, 2, 3), intArrayOf(2, 4, 6), intArrayOf(3, 6, 9))
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Prints multiplication table up to number $input") {
            assertArrayEquals(expected, MultiplicationTable.get(input))
        }
    }
}