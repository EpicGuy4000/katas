package org.kata.hashing

import java.util.*

object RansomNote {
    fun findIfPossible(message: String, magazine: String): Boolean {
        Hashtable<Char, Int>().apply {
            magazine.forEach { this[it] = getOrDefault(it, 0) + 1 }
        }.let { magazineCounter ->
            message.forEach {
                magazineCounter[it] = magazineCounter.getOrDefault(it, 0) - 1
                if (magazineCounter[it]!! < 0) return false
            }
        }

        return true
    }
}