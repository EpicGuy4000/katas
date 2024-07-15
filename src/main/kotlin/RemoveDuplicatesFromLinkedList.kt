package org.kata

object RemoveDuplicatesFromLinkedList {
    fun removeDuplicates(head: SingleLinkedListNode): SingleLinkedListNode {
        var curr: SingleLinkedListNode? = head

        while (curr != null) {
            while (curr.value == curr.next?.value) {
                curr.next = curr.next?.next
            }

            curr = curr.next
        }

        return head
    }
}