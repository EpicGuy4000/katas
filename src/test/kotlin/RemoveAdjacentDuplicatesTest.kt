import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.RemoveAdjacentDuplicates

class RemoveAdjacentDuplicatesTest {
    @TestFactory
    fun sortStack() = listOf(
        "abbaca" to "ca",
        "azxxzy" to "ay",
        "abba" to "",
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Removes duplicates from $input") {
            val output = RemoveAdjacentDuplicates.removeDuplicates(input)
            assertEquals(expected, output)
        }
    }
}