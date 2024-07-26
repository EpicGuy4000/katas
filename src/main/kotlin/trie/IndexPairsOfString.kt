package org.kata.trie

object IndexPairsOfString {
    fun indexPairs(text: String, words: List<String>): List<Pair<Int, Int>> {
        val trie = Trie()
            .apply { words.forEach { insert(it) } }

        val pairs = mutableListOf<Pair<Int, Int>>()

        val wordLengths = words.map { it.length }.toSet()

        for (startingIndex in 0..text.lastIndex) {
            wordLengths
                .filter { text.length - startingIndex >= it }
                .filter {
                    trie.search(
                        text.substring(
                            startingIndex,
                            startingIndex + it
                        )
                    )
                }
                .forEach {
                    pairs.add(startingIndex to startingIndex + it - 1)
                }
        }

        return pairs
    }
}