package linked_list

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.linked_list.ReverseLinkedList
import org.kata.linked_list.SingleLinkedListNode as Node

class ReverseLinkedListTest {
    @TestFactory
    fun reverseLinkedList() = listOf(
        Node.fromList(3, 5, 2) to Node.fromList(2, 5, 3),
        Node(7) to Node(7),
        Node.fromList(-1, 0, 1) to Node.fromList(1, 0, -1),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Reverses a linked list ${input?.print()}") {
            val output = ReverseLinkedList.reverse(input)
            assertEquals(expected, output)
        }
    }
}