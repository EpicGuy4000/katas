package org.kata

class ContainsDuplicates {
    companion object {
        fun containsDuplicates(numbers: List<Int>): Boolean = numbers.toSet().size != numbers.size
    }
}