package org.kata.stack

import java.util.*

class BalancedParentheses {
    companion object {
        fun isBalanced(string: String): Boolean {
            val stack = Stack<Char>()

            for (c in string) {
                when {
                    c == '(' -> stack.push(')')
                    c == '[' -> stack.push(']')
                    c == '{' -> stack.push('}')
                    !stack.isEmpty() && c == stack.peek() -> stack.pop()
                    else -> return false
                }
            }

            return stack.isEmpty()
        }
    }
}