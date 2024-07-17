package org.kata.queue

import java.util.*

object BinaryNumberGenerator {
    fun generate(n: Int): List<String> {
        val out = mutableListOf<String>()
        val queue: Queue<String> = LinkedList()

        queue.add("1")

        repeat(n) {
            val c = queue.poll()
            out.add(c)
            queue.add(c + "0")
            queue.add(c + "1")
        }

        return out
    }
}