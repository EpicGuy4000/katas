import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.FindTheHighestAltitude
import org.kata.RunningSumOf1DArray

class FindTheHighestAltitudeTest {
    @TestFactory
    fun runningSum() = listOf(
        listOf(-5, 1, 5, 0, -7) to 1,
        listOf(4, -3, 2, -1, -2) to 4,
        listOf(2, 2, -3, -1, 2, 1, -5) to 4
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Calculates highest altitude based on gains $input") {
            assertEquals(expected, FindTheHighestAltitude.findTheHighestAltitude(input))
        }
    }
}