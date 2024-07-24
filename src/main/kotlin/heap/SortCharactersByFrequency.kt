package org.kata.heap

import java.util.*

object SortCharactersByFrequency {
    fun frequencySort(string: String): String {
        val counter = HashMap<Char, Int>().apply {
            string.forEach { put(it, getOrDefault(it, 0) + 1) }
        }

        return PriorityQueue(
            string.length,
            Comparator<Char> { o1, o2 -> counter[o1]!!.compareTo(counter[o2]!!) }.reversed()
        )
            .apply {
                string.forEach(this::add)
            }
            .let {
                StringBuilder().apply {
                    while (it.isNotEmpty()) {
                        append(it.remove())
                    }
                }.toString()
            }
    }
}