import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.ReverseString

class ReverseStringTest {
    @TestFactory
    fun reverse() = listOf(
        "Hello, World!" to "!dlroW ,olleH",
        "OpenAI" to "IAnepO",
        "Stacks are fun!" to "!nuf era skcatS",
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Checks if $input is reversed correctly") {
            assertEquals(expected, ReverseString.reverse(input))
        }
    }
}