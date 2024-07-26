package org.kata.graph

import java.util.*

object FindIfPathExistsInGraph {
    fun validPath(edges: List<Pair<Int, Int>>, start: Int, end: Int): Boolean {
        val visited = HashSet<Int>()
        val dfsStack = Stack<Int>()

        val adjacencyList = Hashtable<Int, HashSet<Int>>().apply {
            edges.forEach { (from, to) ->
                computeIfAbsent(from) { HashSet() }.add(to)
                computeIfAbsent(to) { HashSet() }.add(from)
            }
        }

        dfsStack.push(start)
        visited.add(start)

        while (dfsStack.isNotEmpty()) {
            val curr = dfsStack.pop()

            adjacencyList.computeIfAbsent(curr) { HashSet() }
                .filter { !visited.contains(it) }
                .forEach {
                    if (it == end) return true

                    dfsStack.push(it)
                    visited.add(it)
                }
        }

        return false
    }
}