import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.MergeSortedLinkedList
import org.kata.SingleLinkedListNode as Node

class MergeSortedLinkedListTest {
    @TestFactory
    fun removeDuplicates() = listOf(
        Pair(Node(1, Node(3, Node(5))), Node(2, Node(4, Node(6))))
                to Node(1, Node(2, Node(3, Node(4, Node(5, Node(6)))))),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Merges linked lists ${input.first.printRest()} and ${input.second.printRest()} to ${expected.printRest()}") {
            val output = MergeSortedLinkedList.merge(input.first, input.second)
            Assertions.assertEquals(expected, output)
        }
    }
}