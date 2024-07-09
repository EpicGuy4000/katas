import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.SimplifyPath

class SimplifyPathTest {
    @TestFactory
    fun sortStack() = listOf(
        "/a//b////c/d//././/.." to "/a/b/c",
        "/../" to "/",
        "/home//foo/" to "/home/foo"
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Simplifies $input to $expected") {
            val output = SimplifyPath.simplify(input)
            assertEquals(expected, output)
        }
    }
}