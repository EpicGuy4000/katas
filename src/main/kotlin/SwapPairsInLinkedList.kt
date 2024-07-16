package org.kata

object SwapPairsInLinkedList {
    fun swapPairs(head: SingleLinkedListNode?): SingleLinkedListNode? {
        if (head == null) return null
        if (head.next == null) return head

        val newHead = head.next

        var curr: SingleLinkedListNode? = head
        var prev: SingleLinkedListNode? = null

        while (curr?.next != null) {
            val nextCurr = curr.next?.next
            val next = curr.next!!

            prev?.next = next
            next.next = curr
            curr.next = nextCurr

            prev = curr
            curr = nextCurr
        }

        return newHead
    }
}