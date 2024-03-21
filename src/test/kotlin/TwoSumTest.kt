import org.kata.TwoSum
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class TwoSumTest {
    private fun runTest(r: IntArray, n: Int, refSol: Pair<Int,Int>) {
        val userSol = TwoSum.twoSum(r,n).let { (x,y) -> if (x > y) Pair(y,x) else Pair(x,y) }
        assertEquals(refSol,userSol)
    }
    @Test
    fun twoSum() {
        runTest(intArrayOf(1,2,3), 4, Pair(0,2))
        runTest(intArrayOf(1234,5678,9012), 14690, Pair(1,2))
        runTest(intArrayOf(2,2,3), 4, Pair(0,1))
    }
}