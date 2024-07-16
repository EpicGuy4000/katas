package org.kata

object MergeSortedLinkedList {
    fun merge(l1: SingleLinkedListNode, l2: SingleLinkedListNode): SingleLinkedListNode {
        var currL1: SingleLinkedListNode? = l1
        var currL2: SingleLinkedListNode? = l2

        val dummy = SingleLinkedListNode(-1)

        var curr: SingleLinkedListNode = dummy

        while (currL1 != null || currL2 != null) {
            when {
                currL1 !== null && currL2 !== null && currL1.value <= currL2.value -> {
                    curr.next = SingleLinkedListNode(currL1.value)
                    currL1 = currL1.next
                }

                currL2 === null -> {
                    curr.next = SingleLinkedListNode(currL1!!.value)
                    currL1 = currL1.next
                }

                else -> {
                    curr.next = SingleLinkedListNode(currL2.value)
                    currL2 = currL2.next
                }
            }

            curr = curr.next!!
        }

        return dummy.next!!
    }
}