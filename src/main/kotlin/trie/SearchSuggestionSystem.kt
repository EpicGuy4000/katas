package org.kata.trie

import java.util.*

class SearchSuggestionSystem(products: List<String>) {
    private class TrieNode(val value: String) {
        val children = MutableList<TrieNode?>(26) { null }
        var isEndOfWord = false
    }

    private val root = TrieNode("")

    private var currentNode: TrieNode? = root

    init {
        for (product in products) {
            var node = root

            product.forEach {
                if (node.children[it - 'a'] == null)
                    node.children[it - 'a'] = TrieNode(node.value + it)

                node = node.children[it - 'a']!!
            }

            node.isEndOfWord = true
        }
    }

    fun type(char: Char) {
        currentNode = if (currentNode == null) null else currentNode!!.children[char - 'a']
    }

    fun getSuggestions(): List<String> {
        if (currentNode === null) return emptyList()

        val suggestions = mutableListOf<String>()
        val stack: Stack<TrieNode> = Stack()

        stack.add(currentNode)

        while (stack.isNotEmpty() && suggestions.size < 3) {
            val c = stack.pop()

            if (c.isEndOfWord) suggestions.add(c.value)

            c.children.filterNotNull().reversed().forEach { stack.push(it) }
        }

        return suggestions
    }
}