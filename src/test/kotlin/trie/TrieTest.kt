package trie

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.kata.trie.Trie

class TrieTest {
    @Test
    fun example1() {
        val trie = Trie()

        trie.insert("apple")
        Assertions.assertTrue(trie.search("apple"))
        Assertions.assertTrue(trie.startsWith("app"))
    }

    @Test
    fun example2() {
        val trie = Trie()

        trie.insert("banana")
        Assertions.assertFalse(trie.search("apple"))
        Assertions.assertTrue(trie.startsWith("ban"))
        Assertions.assertTrue(trie.search("banana"))
    }

    @Test
    fun example3() {
        val trie = Trie()

        trie.insert("grape")
        Assertions.assertTrue(trie.search("grape"))
        Assertions.assertTrue(trie.startsWith("grap"))
        Assertions.assertTrue(trie.startsWith("gr"))
    }
}