import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.SwapPairsInLinkedList
import org.kata.SingleLinkedListNode as Node

class SwapPairsInLinkedListTest {
    @TestFactory
    fun swapPairs() = listOf(
        Node.fromList(listOf(1, 2, 3, 4)) to Node.fromList(listOf(2, 1, 4, 3)),
        Node.fromList(listOf(7, 8, 9, 10, 11)) to Node.fromList(listOf(8, 7, 10, 9, 11)),
        Node.fromList(listOf(5, 6)) to Node.fromList(listOf(6, 5)),
        Node.fromList(listOf(1)) to Node.fromList(listOf(1)),
        Node.fromList(emptyList()) to null,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Swaps pair in ${input?.print()}") {
            val output = SwapPairsInLinkedList.swapPairs(input)
            Assertions.assertEquals(expected, output)
        }
    }
}