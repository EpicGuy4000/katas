package org.kata

data class SingleLinkedListNode(val value: Int, var next: SingleLinkedListNode? = null) {
    fun printRest(): List<Int> {
        return buildList {
            var curr: SingleLinkedListNode? = this@SingleLinkedListNode
            while (curr != null) {
                add(curr.value)
                curr = curr.next
            }
        }
    }
}