package org.kata.stack

import java.util.*

class ReverseString {
    companion object {
        fun reverse(string: String): String {
            val stack = Stack<Char>()

            string.forEach(stack::push)

            return buildString {
                while (!stack.empty()) {
                    append(stack.pop())
                }
            }
        }
    }
}