package org.kata.array

class ContainsDuplicates {
    companion object {
        fun containsDuplicates(numbers: List<Int>): Boolean = numbers.toSet().size != numbers.size
    }
}