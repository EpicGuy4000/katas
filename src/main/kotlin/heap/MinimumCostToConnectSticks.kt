package org.kata.heap

import java.util.*

object MinimumCostToConnectSticks {
    fun connectSticks(sticks: List<Int>): Int {
        var cost = 0

        PriorityQueue(sticks).apply {
            while (size > 1) {
                val firstStick = remove()
                val secondStick = remove()
                cost += firstStick + secondStick
                add(firstStick + secondStick)
            }
        }

        return cost
    }
}