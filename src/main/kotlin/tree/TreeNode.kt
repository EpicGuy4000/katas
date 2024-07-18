package org.kata.tree

data class TreeNode<T>(val value: T, var left: TreeNode<T>? = null, var right: TreeNode<T>? = null) {
    companion object {
        private fun <T> printSubTree(node: TreeNode<T>?): String {
            if (node == null) return ""
            return printSubTree(node.left) +
                    "${if (node.left != null) "/" else ""}${node.value}${if (node.right != null) "\\" else ""}" +
                    printSubTree(node.right)
        }

        fun <T> inOrderTraversal(
            node: TreeNode<T>?
        ): Iterable<T> {
            val list = mutableListOf<T>()

            inOrderTraversalRecursive(node, list)

            return list
        }

        private fun <T> inOrderTraversalRecursive(
            node: TreeNode<T>?,
            list: MutableList<T>
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