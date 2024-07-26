package org.kata.graph

import java.util.*

object NumberOfProvinces {
    fun findCircleNum(adjacencyMatrix: List<List<Int>>): Int {
        val visited = HashSet<Int>()
        val dfsStack = Stack<Int>()
        var provinces = 0

        (0..adjacencyMatrix.lastIndex).forEach { i ->
            if (!visited.contains(i)) {
                dfsStack.add(i)

                while (dfsStack.isNotEmpty()) {
                    val curr = dfsStack.pop()

                    adjacencyMatrix[curr].forEachIndexed { j, isConnected ->
                        if (isConnected == 1 && !visited.contains(j)) {
                            dfsStack.push(j)
                            visited.add(j)
                        }
                    }
                }

                provinces += 1
            }
        }

        return provinces
    }
}