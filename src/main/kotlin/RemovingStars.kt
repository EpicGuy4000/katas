package org.kata

import java.util.*

class RemovingStars {
    companion object {
        fun removeStars(str: String): String {
            val stack = Stack<Char>()

            for (c in str) {
                when {
                    c != '*' -> stack.push(c)
                    stack.isNotEmpty() -> stack.pop()
                }
            }

            return stack.joinToString("")
        }
    }
}