package org.kata

import java.util.*

class ZigzagIterator(v1: List<Int>, v2: List<Int>) {
    private val queue: Queue<Iterator<Int>> = LinkedList<Iterator<Int>>().apply {
        if (v1.isNotEmpty()) { add(v1.iterator()) }
        if (v2.isNotEmpty()) { add(v2.iterator()) }
    }

    fun next(): Int {
        val it = queue.poll()

        val nextValue = it.next()
        if (it.hasNext()) queue.add(it)

        return nextValue
    }

    fun hasNext(): Boolean = queue.isNotEmpty()
}