import org.kata.EvenNumbersInArray
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class EvenNumbersInArrayTest {

    @Test
    fun evenNumbers() {
        assertEquals(listOf(4, 6, 8), EvenNumbersInArray.evenNumbers(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 3))
        assertEquals(listOf(-8, 26), EvenNumbersInArray.evenNumbers(listOf(-22, 5, 3, 11, 26, -6, -7, -8, -9, -8, 26), 2))
        assertEquals(listOf(6), EvenNumbersInArray.evenNumbers(listOf(6, -25, 3, 7, 5, 5, 7, -3, 23), 1))
    }
}