package linked_list

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.linked_list.MergeSortedLinkedList
import org.kata.linked_list.SingleLinkedListNode as Node

class MergeSortedLinkedListTest {
    @TestFactory
    fun removeDuplicates() = listOf(
        Pair(Node.fromList(1, 3, 5), Node.fromList(2, 4, 6))
                to Node.fromList(1, 2, 3, 4, 5, 6),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Merges linked lists ${input.first?.print()} and ${input.second?.print()} to ${expected?.print()}") {
            val output = MergeSortedLinkedList.merge(input.first, input.second)
            Assertions.assertEquals(expected, output)
        }
    }
}