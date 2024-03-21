package kata

import org.example.kata.EvenNumbersInArray
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class EvenNumbersInArrayTest {

    @Test
    fun evenNumbers() {
        val instance = EvenNumbersInArray()
        assertEquals(listOf(4, 6, 8), instance.evenNumbers(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 3))
        assertEquals(listOf(-8, 26), instance.evenNumbers(listOf(-22, 5, 3, 11, 26, -6, -7, -8, -9, -8, 26), 2))
        assertEquals(listOf(6), instance.evenNumbers(listOf(6, -25, 3, 7, 5, 5, 7, -3, 23), 1))
    }
}