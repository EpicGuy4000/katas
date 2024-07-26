package org.kata.trie

object ExtraCharactersInString {
    private class TrieNode {
        val children = hashMapOf<Char, TrieNode>()
        var isEndOfWord = false
    }

    fun find(string: String, words: List<String>): Int {
        val root = TrieNode()

        for (word in words) {
            var node = root

            word.forEach {
                node = node.children.computeIfAbsent(it) { TrieNode() }
            }

            node.isEndOfWord = true
        }

        var leftoverCharacters = 0
        var i = 0

        while (i < string.length) {
            var node = root
            var currentIndex = i

            while (currentIndex < string.length && node.children[string[currentIndex]] != null) {
                node = node.children[string[currentIndex]]!!
                currentIndex++
            }

            if (!node.isEndOfWord) {
                leftoverCharacters++
                i++
            } else {
                i = currentIndex
            }
        }

        return leftoverCharacters
    }
}