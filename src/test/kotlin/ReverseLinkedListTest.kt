import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.ReverseLinkedList
import org.kata.SingleLinkedListNode as Node

class ReverseLinkedListTest {
    @TestFactory
    fun reverseLinkedList() = listOf(
        Node(3, Node(5, Node(2))) to
                Node(2, Node(5, Node(3))),
        Node(7) to Node(7),
        Node(-1, Node(0, Node(1))) to
                Node(1, Node(0, Node(-1))),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Reverses a linked list ${input.printRest()}") {
            val output = ReverseLinkedList.reverse(input)
            assertEquals(expected, output)
        }
    }
}