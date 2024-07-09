package org.kata

import java.util.*

class MakeStringGreat {
    companion object {
        fun makeGreat(str: String): String {
            val stack = Stack<Char>()

            for (c in str) {
                if (!stack.isEmpty()
                    && c.lowercaseChar() == stack.peek().lowercaseChar()
                    && c.isLowerCase() != stack.peek().isLowerCase()) {
                    stack.pop()
                    continue
                }

                stack.push(c)
            }

            return stack.joinToString("")
        }
    }
}