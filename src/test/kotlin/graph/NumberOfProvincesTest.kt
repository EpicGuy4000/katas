package graph

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.graph.NumberOfProvinces

class NumberOfProvincesTest {
    @TestFactory
    fun findCircleNum() = listOf(
        listOf(listOf(1, 1, 0), listOf(1, 1, 0), listOf(0, 0, 1)) to 2,
        listOf(listOf(1, 0, 0, 1), listOf(0, 1, 1, 0), listOf(0, 1, 1, 0), listOf(1, 0, 0, 1)) to 2,
        listOf(listOf(1, 0, 0), listOf(0, 1, 0), listOf(0, 0, 1)) to 3,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Finds number of subgraphs is '${input}'") {
            val output = NumberOfProvinces.findCircleNum(input)
            Assertions.assertEquals(expected, output)
        }
    }
}