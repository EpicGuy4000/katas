package org.kata.hashing

import java.util.*

class MaximumNumberOfWord(word: String) {
    private val frequencyOfLettersInWord = Hashtable<Char, Int>().apply {
        word.forEach {
            this[it] = getOrDefault(it, 0) + 1
        }
    }

    fun find(string: String): Int {
        return Hashtable<Char, Int>().apply {
            string.filter { it in frequencyOfLettersInWord.keys }.forEach {
                this[it] = getOrDefault(it, 0) + 1
            }

            frequencyOfLettersInWord.forEach { (key, value) ->
                this[key] = getOrDefault(key, 0) / value
            }
        }.minOf { it.value }
    }
}