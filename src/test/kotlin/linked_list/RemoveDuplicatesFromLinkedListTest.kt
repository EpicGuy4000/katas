package linked_list

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.linked_list.RemoveDuplicatesFromLinkedList
import org.kata.linked_list.SingleLinkedListNode as Node

class RemoveDuplicatesFromLinkedListTest {
    @TestFactory
    fun removeDuplicates() = listOf(
        Node.fromList(1, 1, 2) to Node.fromList(1, 2),
        Node.fromList(1, 2, 2, 3) to Node.fromList(1, 2, 3),
        Node.fromList(3, 3, 3) to Node(3),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Removes duplicates from linked list ${input?.print()}") {
            val output = RemoveDuplicatesFromLinkedList.removeDuplicates(input)
            Assertions.assertEquals(expected, output)
        }
    }
}