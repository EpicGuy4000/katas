package org.kata

object PalindromeCheckerWithDoublyLinkedList {
    fun isPalindrome(head: DoublyLinkedListNode?): Boolean {
        val tail = let {
            var curr = head
            while (curr?.next != null) curr = curr.next
            curr
        }

        var currHead: DoublyLinkedListNode? = head
        var currTail: DoublyLinkedListNode? = tail

        while (currHead != null && currTail != null && currHead.value == currTail.value) {
            currHead = currHead.next
            currTail = currTail.prev
        }

        return currHead?.value == currTail?.value
    }
}