package org.kata

/**
 * Write a function that takes an array of numbers (integers for the tests) and a target number.
 * It should find two different items in the array that, when added together, give the target value.
 * The indices of these items should then be returned in a tuple / list (depending on your language) like so: (index1, index2).
 *
 * For the purposes of this kata, some tests may have multiple answers; any valid solutions will be accepted.
 *
 * The input will always be valid (numbers will be an array of length 2 or greater,
 * and all the items will be numbers; target will always be the sum of two different items from that array).
 *
 * Based on: https://leetcode.com/problems/two-sum/
 */
class TwoSum {
    companion object {
        fun twoSum(numbers: IntArray, target: Int): Pair<Int,Int> {
            val matchmaker = mutableMapOf<Int, Int>()

            for (i in 0..numbers.lastIndex) {
                if (matchmaker.containsKey(numbers[i])) return Pair(matchmaker[numbers[i]]!!, i)

                matchmaker[target - numbers[i]] = i
            }

            return Pair(-1, -1)
        }
    }
}