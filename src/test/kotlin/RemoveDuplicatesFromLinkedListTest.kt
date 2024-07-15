import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.RemoveDuplicatesFromLinkedList
import org.kata.SingleLinkedListNode

class RemoveDuplicatesFromLinkedListTest {
    @TestFactory
    fun removeDuplicates() = listOf(
        SingleLinkedListNode(1, SingleLinkedListNode(1, SingleLinkedListNode(2))) to SingleLinkedListNode(
            1,
            SingleLinkedListNode(2)
        ),
        SingleLinkedListNode(
            1,
            SingleLinkedListNode(2, SingleLinkedListNode(2, SingleLinkedListNode(3)))
        ) to SingleLinkedListNode(1, SingleLinkedListNode(2, SingleLinkedListNode(3))),
        SingleLinkedListNode(3, SingleLinkedListNode(3, SingleLinkedListNode(3))) to SingleLinkedListNode(3),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Removes duplicates from linked list ${input.printRest()}") {
            val output = RemoveDuplicatesFromLinkedList.removeDuplicates(input)
            Assertions.assertEquals(expected, output)
        }
    }
}