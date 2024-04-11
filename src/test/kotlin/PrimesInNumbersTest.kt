import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.PrimesInNumbers

class PrimesInNumbersTest {
    @TestFactory
    fun decompose() = listOf(
        86240 to "(2**5)(5)(7**2)(11)",
        1024 to "(2**10)",
        7775460 to "(2**2)(3**3)(5)(7)(11**2)(17)"
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Prints factors for number $input") {
            Assertions.assertEquals(expected, PrimesInNumbers.decompose(input).map { (prime, factor) -> if (factor == 1) "(${prime})" else "(${prime}**${factor})" }.joinToString(""))
        }
    }
}