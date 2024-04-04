import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.Int32ToIpv4

class Int32ToIpv4Test {
    @TestFactory
    fun convert() = listOf(
        0u to "0.0.0.0",
        1u to "0.0.0.1",
        32u to "0.0.0.32",
        2561u to "0.0.10.1",
        2149583361u to "128.32.10.1"
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Converts $input to $expected") {
            assertEquals(expected, Int32ToIpv4.convert(input))
        }
    }
}