package org.kata.tree

object KthSmallestBST {
    fun <T> get(root: TreeNode<T>?, k: Int): T? {
        if (root == null) return null

        val (found, _) = inOrderTraversalKthElement(root, k)

        return found?.value
    }

    private fun <T> inOrderTraversalKthElement(
        node: TreeNode<T>?,
        k: Int
    ): Pair<TreeNode<T>?, Int> {
        if (node == null) return Pair(null, k)

        val (found, newK) = inOrderTraversalKthElement(node.left, k)

        if (found != null) return Pair(found, newK)
        if (newK == 1) return Pair(node, 0)
        return inOrderTraversalKthElement(node.right, newK - 1)
    }
}