package trie

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.kata.trie.SearchSuggestionSystem

class SearchSuggestionSystemTest {
    @Test
    fun app() {
        val searchSuggestionSystem = SearchSuggestionSystem(listOf("apple", "apricot", "application"))

        searchSuggestionSystem.type('a')
        Assertions.assertArrayEquals(
            arrayOf("apple", "application", "apricot"),
            searchSuggestionSystem.getSuggestions().toTypedArray()
        )

        searchSuggestionSystem.type('p')
        Assertions.assertArrayEquals(
            arrayOf("apple", "application", "apricot"),
            searchSuggestionSystem.getSuggestions().toTypedArray()
        )

        searchSuggestionSystem.type('p')
        Assertions.assertArrayEquals(
            arrayOf("apple", "application"),
            searchSuggestionSystem.getSuggestions().toTypedArray()
        )
    }

    @Test
    fun ki() {
        val searchSuggestionSystem = SearchSuggestionSystem(listOf("king", "kingdom", "kit"))

        searchSuggestionSystem.type('k')
        Assertions.assertArrayEquals(
            arrayOf("king", "kingdom", "kit"),
            searchSuggestionSystem.getSuggestions().toTypedArray()
        )

        searchSuggestionSystem.type('i')
        Assertions.assertArrayEquals(
            arrayOf("king", "kingdom", "kit"),
            searchSuggestionSystem.getSuggestions().toTypedArray()
        )
    }

    @Test
    fun farm() {
        val searchSuggestionSystem = SearchSuggestionSystem(listOf("fantasy", "fast", "festival"))

        searchSuggestionSystem.type('f')
        Assertions.assertArrayEquals(
            arrayOf("fantasy", "fast", "festival"),
            searchSuggestionSystem.getSuggestions().toTypedArray()
        )

        searchSuggestionSystem.type('a')
        Assertions.assertArrayEquals(
            arrayOf("fantasy", "fast"),
            searchSuggestionSystem.getSuggestions().toTypedArray()
        )

        searchSuggestionSystem.type('r')
        Assertions.assertArrayEquals(
            emptyArray(),
            searchSuggestionSystem.getSuggestions().toTypedArray()
        )

        searchSuggestionSystem.type('m')
        Assertions.assertArrayEquals(
            emptyArray(),
            searchSuggestionSystem.getSuggestions().toTypedArray()
        )
    }
}