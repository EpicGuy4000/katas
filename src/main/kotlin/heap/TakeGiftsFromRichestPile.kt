package org.kata.heap

import java.util.*
import kotlin.math.sqrt

object TakeGiftsFromRichestPile {
    fun remainingGifts(list: List<Int>, k: Int): Int =
        PriorityQueue(list.size, Comparator.reverseOrder<Int>()).apply {
            addAll(list)

            for (i in 0..<k) add(sqrt(remove().toDouble()).toInt())
        }.let {
            var sum = 0
            while (it.isNotEmpty()) {
                sum += it.remove()
            }
            sum
        }
}