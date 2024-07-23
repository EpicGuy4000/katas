package org.kata.hashing

import java.util.*

object LongestPalindrome {
    fun find(string: String): Int {
        val counter = Hashtable<Char, Int>().apply {
            string.forEach { this[it.lowercaseChar()] = getOrDefault(it.lowercaseChar(), 0) + 1 }
        }
        var hasRemainder = false
        var palindromeLength = 0

        for (value in counter.values) {
            palindromeLength += value / 2
            hasRemainder = hasRemainder || value % 2 != 0
        }

        return palindromeLength * 2 + if (hasRemainder) 1 else 0
    }
}