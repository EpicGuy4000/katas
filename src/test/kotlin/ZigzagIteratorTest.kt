import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.ZigzagIterator

class ZigzagIteratorTest {
    @TestFactory
    fun reverse() = listOf(
        Pair(listOf(1, 2), listOf(3, 4, 5, 6)) to listOf(1, 3, 2, 4, 5, 6),
        Pair(listOf(1, 2, 3, 4), listOf(5, 6)) to listOf(1, 5, 2, 6, 3, 4),
        Pair(listOf(1, 2), emptyList<Int>()) to listOf(1, 2),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Checks if $input vectors are iterated in expected order") {
            val actual = mutableListOf<Int>()
            val iterator = ZigzagIterator(input.first, input.second)

            while (iterator.hasNext()) {
                actual.add(iterator.next())
            }

            assertEquals(expected, actual)
        }
    }
}