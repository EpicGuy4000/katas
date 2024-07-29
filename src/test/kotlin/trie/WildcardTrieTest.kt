package trie

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.kata.trie.WildcardTrie

class WildcardTrieTest {
    @Test
    fun example1() {
        val trie = WildcardTrie()

        trie.insert("apple")
        trie.insert("banana")
        Assertions.assertTrue(trie.search("apple"))
        Assertions.assertTrue(trie.search("......"))
    }

    @Test
    fun example2() {
        val trie = WildcardTrie()

        trie.insert("cat")
        trie.insert("dog")
        Assertions.assertTrue(trie.search("c.t"))
        Assertions.assertFalse(trie.search("d..g"))
    }

    @Test
    fun example3() {
        val trie = WildcardTrie()

        trie.insert("hello")
        Assertions.assertTrue(trie.search("h.llo"))
        Assertions.assertTrue(trie.search("h...o"))
    }
}