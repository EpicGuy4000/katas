package org.kata.trie

import java.util.*

class WildcardTrie {
    private class Node(var isEnd: Boolean) {
        val children: HashMap<Char, Node> = hashMapOf()
    }

    private val root = Node(false)

    fun insert(word: String) {
        var current = root
        for (c in word) {
            current = current.children.computeIfAbsent(c) { Node(false) }
        }
        current.isEnd = true
    }

    fun search(word: String): Boolean {
        val considerations: Queue<Node> = LinkedList()

        considerations.add(root)
        var index = 0

        while (considerations.isNotEmpty()) {
            if (index == word.length) {
                return considerations.any { it.isEnd }
            }

            for (i in 0..<considerations.size) {
                val current = considerations.poll()

                current.children.filter { it.key == word[index] || word[index] == '.' }
                    .forEach { considerations.add(it.value) }
            }

            index++
        }

        return false
    }
}