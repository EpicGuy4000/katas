import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.PalindromeCheckerWithDoublyLinkedList
import org.kata.DoublyLinkedListNode as Node

class PalindromeCheckerWithDoublyLinkedListTest {
    @TestFactory
    fun checksIfDoublyLinkedListIsAPalindrome() = listOf(
        Node.fromList(listOf(1, 2, 3, 2, 1)) to true,
        Node.fromList(listOf(1, 2, 2, 3)) to false,
        Node.fromList(listOf(1, 1, 1, 1)) to true,
        Node.fromList(listOf(1, 2, 2, 1)) to true,
        Node.fromList(listOf(1)) to true,
        Node.fromList(emptyList()) to true,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Checks if ${input?.print()} is a palindrome") {
            val output = PalindromeCheckerWithDoublyLinkedList.isPalindrome(input)
            Assertions.assertEquals(expected, output)
        }
    }
}