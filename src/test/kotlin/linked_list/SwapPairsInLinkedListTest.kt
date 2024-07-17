package linked_list

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.linked_list.SwapPairsInLinkedList
import org.kata.linked_list.SingleLinkedListNode as Node

class SwapPairsInLinkedListTest {
    @TestFactory
    fun swapPairs() = listOf(
        Node.fromList(1, 2, 3, 4) to Node.fromList(2, 1, 4, 3),
        Node.fromList(7, 8, 9, 10, 11) to Node.fromList(8, 7, 10, 9, 11),
        Node.fromList(5, 6) to Node.fromList(6, 5),
        Node(1) to Node(1),
        null to null,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Swaps pair in ${input?.print()}") {
            val output = SwapPairsInLinkedList.swapPairs(input)
            Assertions.assertEquals(expected, output)
        }
    }
}