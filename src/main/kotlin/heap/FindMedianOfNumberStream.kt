package org.kata.heap

import java.util.*

class FindMedianOfNumberStream {
    private val minHeap = PriorityQueue<Int>(7, Comparator.naturalOrder())
    private val maxHeap = PriorityQueue<Int>(7, Comparator.reverseOrder())

    fun insertNum(num: Int) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num)
        } else {
            minHeap.add(num)
        }

        if (maxHeap.size > minHeap.size + 1) {
            minHeap.add(maxHeap.remove())
        } else if (maxHeap.size < minHeap.size) {
            maxHeap.add(minHeap.remove())
        }
    }

    fun findMedian(): Double = if ((minHeap.size + maxHeap.size) % 2 == 0)
        minHeap.peek().toDouble() / 2.0 + maxHeap.peek().toDouble() / 2.0
    else maxHeap.peek().toDouble()
}