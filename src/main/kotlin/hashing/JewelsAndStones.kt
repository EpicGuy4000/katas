package org.kata.hashing

object JewelsAndStones {
    fun countJewels(jewelTypes: String, stones: String): Int = jewelTypes.toHashSet().let { jewelsSet ->
        stones.count { jewelsSet.contains(it) }
    }
}