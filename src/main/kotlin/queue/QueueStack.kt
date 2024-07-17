package org.kata.queue

import java.util.*

interface SimpleStack<T> {
    fun push(x: T)
    fun pop(): T
    fun isEmpty(): Boolean
}

class QueueStack<T> : SimpleStack<T> {
    private var backingQueue: Queue<T> = LinkedList()
    private var helperQueue: Queue<T> = LinkedList()

    override fun push(x: T) {
        backingQueue.add(x)
    }

    override fun pop(): T {
        var el: T
        do {
            el = backingQueue.poll()
            if (backingQueue.isNotEmpty()) {
                helperQueue.add(el)
            }
        } while (backingQueue.isNotEmpty())

        backingQueue = helperQueue.also { helperQueue = backingQueue }

        return el
    }

    override fun isEmpty(): Boolean = backingQueue.isEmpty()
}