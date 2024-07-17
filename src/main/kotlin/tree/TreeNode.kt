package org.kata.tree

data class TreeNode(val value: Int, var left: TreeNode? = null, var right: TreeNode? = null) {
    companion object {
        private fun printSubTree(node: TreeNode?): String {
            if (node == null) return ""
            return printSubTree(node.left) +
                    "${if (node.left != null) "/" else ""}${node.value}${if (node.right != null) "\\" else ""}" +
                    printSubTree(node.right)
        }
    }

    override fun toString(): String = value.toString()

    fun print(): String = printSubTree(this)
}