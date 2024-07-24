package heap

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.heap.MinimumCostToConnectSticks

class MinimumCostToConnectSticksTest {
    @TestFactory
    fun connectSticks() = listOf(
        listOf(2, 4, 3) to 14,
        listOf(1, 8, 2, 5) to 27,
        listOf(5, 5, 5, 5) to 40,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Finds minimum cost to connect all sticks of lengths '${input}'") {
            val output = MinimumCostToConnectSticks.connectSticks(input)
            Assertions.assertEquals(expected, output)
        }
    }
}