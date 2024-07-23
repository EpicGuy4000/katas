package org.kata.heap

import java.util.Collections.swap

class MinHeap(list: List<Int>) {
    private var list: MutableList<Int> = list.toMutableList()

    init {
        for (i in (0..list.size / 2).reversed()) {
            heapify(i)
        }
    }

    fun peekTop(): Int? = list.firstOrNull()

    fun insert(value: Int) {
        list.add(value)

        var index = list.lastIndex

        while (index > 0 && list[(index - 1) / 2] > value) {
            swap(list, index, (index - 1) / 2)
            index = (index - 1) / 2
        }
    }

    private fun heapify(index: Int) {
        var currIndex = index

        var leftChildIndex = (currIndex * 2) + 1
        var rightChildIndex = (currIndex * 2) + 2

        while (leftChildIndex < list.size) {
            val indexOfSmallest = sequenceOf(currIndex, leftChildIndex, rightChildIndex)
                .filter { it < list.size }
                .minBy { list[it] }

            if (indexOfSmallest == currIndex) break

            swap(list, currIndex, indexOfSmallest)
            currIndex = indexOfSmallest

            leftChildIndex = (currIndex * 2) + 1
            rightChildIndex = (currIndex * 2) + 2
        }
    }

    fun removeTop(): Int? {
        if (list.isEmpty()) return null

        swap(list, 0, list.lastIndex)
        val top = list.removeAt(list.lastIndex)

        heapify(0)

        return top
    }
}