package org.kata

class RunningSumOf1DArray {
    companion object {
        fun runningSum(numbers: List<Int>): List<Int> = mutableListOf<Int>().apply {
            var currentSum = 0

            for (i in 0..numbers.lastIndex) {
                currentSum += numbers[i]
                add(currentSum)
            }
        }
    }
}