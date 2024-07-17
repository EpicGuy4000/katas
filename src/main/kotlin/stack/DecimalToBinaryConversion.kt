package org.kata.stack

import java.util.*

class DecimalToBinaryConversion {
    companion object {
        fun convert(value: Int): String {
            val stack = Stack<Int>()

            var currentValue = value

            while (currentValue > 0) {
                stack.push(currentValue % 2)
                currentValue /= 2
            }

            return buildString { while (!stack.isEmpty()) append(stack.pop()) }
        }
    }
}