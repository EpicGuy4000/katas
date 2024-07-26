package trie

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.trie.IndexPairsOfString

class IndexPairsOfStringTest {
    @TestFactory
    fun indexPairs() = listOf(
        Pair("bluebirdskyscrapper", listOf("blue", "bird", "sky")) to listOf(Pair(0, 3), Pair(4, 7), Pair(8, 10)),
        Pair("programmingisfun", listOf("pro", "is", "fun", "gram")) to listOf(
            Pair(0, 2),
            Pair(3, 6),
            Pair(11, 12),
            Pair(13, 15)
        ),
        Pair("interstellar", listOf("stellar", "star", "inter")) to listOf(
            Pair(0, 4),
            Pair(5, 11),
        ),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Find all index pairs for words '${input.second}'") {
            val output = IndexPairsOfString.indexPairs(input.first, input.second)
            Assertions.assertArrayEquals(expected.toTypedArray(), output.toTypedArray())
        }
    }
}