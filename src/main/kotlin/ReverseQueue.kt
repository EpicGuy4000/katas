package org.kata

import java.util.*

class ReverseQueue {
    companion object {
        fun reverse(queue: Queue<Int>): Queue<Int> {
            val stack = Stack<Int>()

            while (queue.isNotEmpty()) stack.push(queue.poll())
            while (stack.isNotEmpty()) queue.add(stack.pop())

            return queue
        }
    }
}