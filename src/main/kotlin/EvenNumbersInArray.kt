package org.kata

/**
 * Given an array of numbers, return a new array of length `number` containing the last even numbers
 * from the original array (in the same order).
 * The original array will be not empty and will contain at least "number" even numbers.
 */
class EvenNumbersInArray {
    companion object {
        fun evenNumbers(array: List<Int>, number: Int): List<Int> = array.filter { it % 2 == 0 }.takeLast(number)
    }
}