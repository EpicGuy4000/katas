package org.kata.heap

import java.util.Collections.swap

class Heap<T>(list: List<T>, val priorityFunction: (T) -> Int) {
    private var list: MutableList<T> = list.toMutableList()

    init {
        for (i in (0..list.size / 2).reversed()) {
            heapify(i)
        }
    }

    fun peekTop(): T? = list.firstOrNull()

    fun insert(value: T) {
        list.add(value)

        var index = list.lastIndex

        while (index > 0 && priorityFunction(list[(index - 1) / 2]) > priorityFunction(value)) {
            swap(list, index, (index - 1) / 2)
            index = (index - 1) / 2
        }
    }

    fun removeTop(): T? {
        if (list.isEmpty()) return null

        swap(list, 0, list.lastIndex)
        val top = list.removeAt(list.lastIndex)

        heapify(0)

        return top
    }

    private fun heapify(index: Int) {
        var currIndex = index

        var leftChildIndex = (currIndex * 2) + 1
        var rightChildIndex = (currIndex * 2) + 2

        while (leftChildIndex < list.size) {
            val lowestPriority = sequenceOf(currIndex, leftChildIndex, rightChildIndex)
                .filter { it < list.size }
                .minBy { priorityFunction(list[it]) }

            if (lowestPriority == currIndex) break

            swap(list, currIndex, lowestPriority)
            currIndex = lowestPriority

            leftChildIndex = (currIndex * 2) + 1
            rightChildIndex = (currIndex * 2) + 2
        }
    }
}