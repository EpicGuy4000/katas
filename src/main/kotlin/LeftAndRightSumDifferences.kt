package org.kata

import kotlin.math.abs

class LeftAndRightSumDifferences {
    companion object {
        fun getDifferenceArray(numbers: List<Int>): Array<Int> = Array<Int>(numbers.size) { 0 }.apply {
            var currentLeftSum = 0

            for (i in 0..numbers.lastIndex) {
                currentLeftSum += numbers[i]
                set(i, currentLeftSum)
            }

            var currentRightSum = 0

            for (i in numbers.lastIndex downTo 1) {
                set(i, abs(get(i - 1) - currentRightSum))
                currentRightSum += numbers[i]
            }

            set(0, currentRightSum)
        }
    }
}