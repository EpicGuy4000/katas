import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.ContainsDuplicates

class ContainsDuplicatesTest {
    @TestFactory
    fun containsDuplicates() = listOf(
        listOf(1, 2, 3, 4) to false,
        listOf(1, 2, 3, 1) to true,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Checks if $input contains duplicates") {
            assertEquals(expected, ContainsDuplicates.containsDuplicates(input))
        }
    }
}