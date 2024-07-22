package org.kata.hashing

import java.util.*

object FirstNonRepeatingCharacter {
    fun find(string: String): Int {
        val counter = Hashtable<Char, Int>()

        string.forEach { counter[it] = counter.getOrDefault(it, 0) + 1 }

        return (0..string.lastIndex).firstOrNull { counter[string[it]] == 1 } ?: -1
    }
}