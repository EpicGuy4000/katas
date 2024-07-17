package org.kata.queue

import java.util.*

object PalindromeChecker {
    fun check(string: String): Boolean {
        val deque: Deque<Char> = LinkedList()

        string.filter { it.isLetterOrDigit() }.forEach { deque.add(it.lowercaseChar()) }

        while (deque.size > 1) if (deque.pollFirst() != deque.pollLast()) return false

        return true
    }
}