package graph

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.graph.FindIfPathExistsInGraph

class FindIfPathExistsInGraphTest {
    @TestFactory
    fun validPath() = listOf(
        Triple(listOf(Pair(0, 1), Pair(1, 2), Pair(2, 3)), 0, 3) to true,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Test if path from of '${input.second}' to '${input.third}' exists") {
            val (edgeList, start, end) = input

            val output = FindIfPathExistsInGraph.validPath(
                edgeList,
                start,
                end
            )
            Assertions.assertEquals(expected, output)
        }
    }
}