package heap

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.kata.heap.FindMedianOfNumberStream

class FindMedianOfNumberStreamTest {
    @Test
    @DisplayName("Find median of a stream of numbers")
    fun findMedianOfStream() {
        val medianFinder = FindMedianOfNumberStream()
        medianFinder.apply {
            insertNum(3)
            insertNum(1)
        }.run {
            Assertions.assertEquals(2.0, findMedian())
            this
        }.apply {
            insertNum(5)
        }.run {
            Assertions.assertEquals(3.0, findMedian())
            this
        }.apply {
            insertNum(4)
        }.run {
            Assertions.assertEquals(3.5, findMedian())
            this
        }
    }
}