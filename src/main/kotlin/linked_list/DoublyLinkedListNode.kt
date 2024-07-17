package org.kata.linked_list

data class DoublyLinkedListNode(
    val value: Int,
    var next: DoublyLinkedListNode? = null,
    var prev: DoublyLinkedListNode? = null
) {
    override fun toString(): String = value.toString()

    companion object {
        fun fromList(vararg elements: Int): DoublyLinkedListNode? {
            val list = elements.asList()
            if (list.isEmpty()) return null

            val nodes = list.map { DoublyLinkedListNode(it) }
            for (i in nodes.indices) {
                if (i > 0) nodes[i].prev = nodes[i - 1]
                if (i < nodes.lastIndex) nodes[i].next = nodes[i + 1]
            }
            return nodes[0]
        }
    }

    fun print(): List<Int> {
        return buildList {
            var curr: DoublyLinkedListNode? = this@DoublyLinkedListNode
            while (curr != null) {
                add(curr.value)
                curr = curr.next
            }
        }
    }
}