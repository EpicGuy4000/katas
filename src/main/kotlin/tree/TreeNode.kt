package org.kata.tree

data class TreeNode(val value: Int, var left: TreeNode? = null, var right: TreeNode? = null) {
    companion object {
        private fun printSubTree(node: TreeNode?): String {
            if (node == null) return ""
            return printSubTree(node.left) +
                    "${if (node.left != null) "/" else ""}${node.value}${if (node.right != null) "\\" else ""}" +
                    printSubTree(node.right)
        }

        fun inOrderTraversal(
            node: TreeNode?
        ): Iterable<Int> {
            val list = mutableListOf<Int>()

            inOrderTraversalRecursive(node, list)

            return list
        }

        private fun inOrderTraversalRecursive(
            node: TreeNode?,
            list: MutableList<Int>
        ) {
            if (node == null) return

            inOrderTraversalRecursive(node.left, list)
            list.add(node.value)
            inOrderTraversalRecursive(node.right, list)
        }
    }

    override fun toString(): String = value.toString()

    fun print(): String = printSubTree(this)
}