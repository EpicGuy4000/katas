package org.kata.hashing

import kotlin.math.max

object LongestSubstringWithoutRepeatingCharacters {
    fun find(string: String): Int {
        val hashSet = hashSetOf<Char>()

        var start = 0
        var end = 0

        var maxLength = 0

        string.forEach {
            if (!hashSet.add(it)) {
                maxLength = max(maxLength, end - start)
                for (i in start until end) {
                    hashSet.remove(string[i])
                    start++

                    if (string[i] == it) break
                }
                hashSet.add(it)
            }

            end++
        }

        return max(maxLength, end - start)
    }
}