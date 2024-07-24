package heap

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.heap.TakeGiftsFromRichestPile

class TakeGiftsFromRichestPileTest {
    @TestFactory
    fun countOneUps() = listOf(
        Pair(listOf(4, 9, 16), 2) to 11,
        Pair(listOf(1, 2, 3), 1) to 4,
        Pair(listOf(25, 36, 49), 3) to 18,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Counts leftover gifts in '${input.first}' after '${input.second}' cycles") {
            val output = TakeGiftsFromRichestPile.remainingGifts(input.first, input.second)
            Assertions.assertEquals(expected, output)
        }
    }
}