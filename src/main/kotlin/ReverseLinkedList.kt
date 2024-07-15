package org.kata

object ReverseLinkedList {
    fun reverse(head: SingleLinkedListNode): SingleLinkedListNode {
        var newHead = head
        var prev: SingleLinkedListNode? = null

        while (newHead.next != null) {
            newHead = newHead.next!!
                .also { newHead.next = prev }
                .also { prev = newHead }
        }

        newHead.next = prev

        return newHead
    }
}