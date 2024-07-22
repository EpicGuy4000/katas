package org.kata.hashing

import java.util.*

object LargestUniqueNumber {
    fun find(list: List<Int>): Int = Hashtable<Int, Int>().apply {
        list.forEach { this[it] = getOrDefault(it, 0) + 1 }
    }.filter { it.value == 1 }
        .maxOfOrNull { it.key } ?: -1
}