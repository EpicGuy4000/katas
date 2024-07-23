package org.kata.hashing

object CountingElements {
    fun countWhereOneUpExists(list: List<Int>): Int = list.toHashSet().let {
        it.count { el ->
            it.contains(el + 1)
        }
    }
}