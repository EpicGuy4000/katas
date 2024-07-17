package org.kata.stack

import java.util.*

class SimplifyPath {
    companion object {
        fun simplify(path: String): String {
            val stack = Stack<String>()

            path.split("/").forEach {
                when (it) {
                    ".." -> if (!stack.isEmpty()) stack.pop()
                    "" -> {}
                    "." -> {}
                    else -> stack.push(it)
                }
            }

            val output = buildString {
                if (stack.isEmpty()) append("/")

                while (!stack.empty()) {
                    insert(0, "/" + stack.pop())
                }
            }

            return output
        }
    }
}