package org.kata.stack

import java.util.*

class RemoveAdjacentDuplicates {
    companion object {
        fun removeDuplicates(value: String): String {
            val stack = Stack<Char>()

            for (c in value) {
                if (!stack.isEmpty() && c == stack.peek()) {
                    stack.pop()
                    continue
                }

                stack.push(c)
            }

            return stack.joinToString("")
        }
    }
}