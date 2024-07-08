package org.kata

import java.util.*

class NextGreaterElement {
    companion object {
        fun getNges(value: Array<Int>): Array<Int> {
            val list = MutableList(value.size) { -1 }
            val stack = Stack<Int>()

            for (i in value.indices.reversed()) {
                while (!stack.isEmpty() && stack.peek() <= value[i]) {
                    stack.pop()
                }

                if (!stack.isEmpty()) list[i] = stack.peek()
                stack.push(value[i])
            }

            return list.toTypedArray<Int>()
        }
    }
}