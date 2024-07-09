package org.kata

import java.util.*

class SortingStack {
    companion object {
        fun sort(values: Stack<Int>): Stack<Int> {
            val downStack = Stack<Int>()

            while (values.isNotEmpty()) {
                val element = values.pop()

                while (downStack.isNotEmpty() && downStack.peek() < element) {
                    values.push(downStack.pop())
                }

                downStack.push(element)
            }

            while (downStack.isNotEmpty()) values.push(downStack.pop())

            return values
        }
    }
}