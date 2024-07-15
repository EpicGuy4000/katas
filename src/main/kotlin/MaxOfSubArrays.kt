package org.kata

import java.util.*

object MaxOfSubArrays {
    fun findMax(input: List<Int>, subarraySize: Int): List<Int> {
        val queue: Queue<Int> = LinkedList()
        val subMaxes = mutableListOf<Int>()

        for (i in 0..<subarraySize) queue.add(input[i])

        for (i in 0..input.size-subarraySize) {
            var max = queue.poll()

            for (j in 1..<subarraySize) {
                val a = queue.poll()
                max = maxOf(max, a)
                queue.add(a)
            }

            if (i + subarraySize < input.size) queue.add(input[i + subarraySize])
            subMaxes.add(max)
        }

        return subMaxes
    }
}