package org.kata

class SumConsecutiveNumbers {
    companion object {
        fun sum(numbers: List<Int>): List<Int> = mutableListOf<Int>().apply {
            var lastValue = numbers[0]
            var currentSum = 0

            for (number in numbers) {
                if (number != lastValue) {
                    add(currentSum)
                    currentSum = 0
                    lastValue = number
                }
                currentSum += number
            }

            add(currentSum)
        }
    }
}