package heap

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.heap.SortCharactersByFrequency
import org.opentest4j.AssertionFailedError

class SortCharactersByFrequencyTest {
    @TestFactory
    fun frequencySort() = listOf(
        "apple" to sequenceOf("ppale", "ppael", "pplae", "pplea", "ppela", "ppeal"),
        "banana" to sequenceOf("aaannb"),
        "aabb" to sequenceOf("aabb", "bbaa", "abab", "abba", "baba", "baab"),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Sorts '${input}' characters by frequency") {
            val output = SortCharactersByFrequency.frequencySort(input)
            var oneIsTrue = false

            expected.forEach {
                try {
                    Assertions.assertEquals(it, output)
                    oneIsTrue = true
                } catch (_: AssertionFailedError) {
                }
            }

            Assertions.assertTrue(oneIsTrue)
        }
    }
}