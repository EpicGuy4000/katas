package org.kata.hashing

object UniqueNumberOfOccurrences {
    fun checkIfCountsAreUnique(list: List<Int>): Boolean = HashMap<Int, Int>().apply {
        list.forEach {
            this[it] = this.getOrDefault(it, 0) + 1
        }
    }.let {
        it.values.toHashSet().size == it.size
    }
}