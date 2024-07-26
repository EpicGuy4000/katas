package org.kata.graph

object MinimumNumberOfVerticesToReachAllNodes {
    fun findVertices(n: Int, edges: List<Pair<Int, Int>>): List<Int> {
        val unreachable = (0..<n).toHashSet()

        edges.forEach { unreachable.remove(it.second) }

        return unreachable.toList()
    }
}