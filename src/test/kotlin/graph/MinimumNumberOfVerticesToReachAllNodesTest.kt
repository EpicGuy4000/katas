package graph

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.graph.MinimumNumberOfVerticesToReachAllNodes

class MinimumNumberOfVerticesToReachAllNodesTest {
    @TestFactory
    fun findSmallestSetOfVertices() = listOf(
        Pair(6, listOf(Pair(0, 1), Pair(0, 2), Pair(2, 5), Pair(3, 4), Pair(4, 2))) to listOf(0, 3),
        Pair(3, listOf(Pair(0, 1), Pair(2, 1))) to listOf(0, 2),
        Pair(5, listOf(Pair(0, 1), Pair(2, 1), Pair(3, 4))) to listOf(0, 2, 3),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Find smallest set of vertices to reach all node in '${input.second}'") {
            val output = MinimumNumberOfVerticesToReachAllNodes.findVertices(input.first, input.second)
            Assertions.assertArrayEquals(expected.toTypedArray(), output.toTypedArray())
        }
    }
}