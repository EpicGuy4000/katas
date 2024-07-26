package org.kata.trie

class Trie {
    private class Node(var isEndOfWord: Boolean) {
        val children: HashMap<Char, Node> = hashMapOf()

        fun insert(word: String, currentIndex: Int) {
            val child = children.computeIfAbsent(word[currentIndex]) { Node(false) }

            if (currentIndex == word.length - 1) child.isEndOfWord = true
            else child.insert(word, currentIndex + 1)
        }

        fun find(word: String, currentIndex: Int): Boolean {
            if (currentIndex == word.length) return isEndOfWord

            return children[word[currentIndex]]?.find(word, currentIndex + 1) ?: false
        }

        fun startsWith(prefix: String, currentIndex: Int): Boolean {
            if (currentIndex == prefix.length) return true

            return children[prefix[currentIndex]]?.startsWith(prefix, currentIndex + 1) ?: false
        }
    }

    private val root = Node(false)

    fun insert(word: String) = root.insert(word, 0)

    fun search(word: String): Boolean = root.find(word, 0)

    fun startsWith(prefix: String): Boolean = root.startsWith(prefix, 0)
}