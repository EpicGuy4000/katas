package org.kata.linked_list

data class SingleLinkedListNode(val value: Int, var next: SingleLinkedListNode? = null) {
    companion object {
        fun fromList(vararg elements: Int): SingleLinkedListNode? {
            val list = elements.asList()
            if (list.isEmpty()) return null

            val nodes = list.map { SingleLinkedListNode(it) }
            for (i in 0..<nodes.lastIndex) {
                nodes[i].next = nodes[i + 1]
            }
            return nodes[0]
        }
    }

    fun print(): List<Int> {
        return buildList {
            var curr: SingleLinkedListNode? = this@SingleLinkedListNode
            while (curr != null) {
                add(curr.value)
                curr = curr.next
            }
        }
    }
}