package org.kata.tree

object KthSmallestBST {
    fun get(root: TreeNode?, k: Int): Int {
        if (root == null) return -1

        val (found, _) = inOrderTraversalKthElement(root, k)

        return found?.value ?: -1
    }

    private fun inOrderTraversalKthElement(
        node: TreeNode?,
        k: Int
    ): Pair<TreeNode?, Int> {
        if (node == null) return Pair(null, k)

        val (found, newK) = inOrderTraversalKthElement(node.left, k)

        if (found != null) return Pair(found, newK)
        if (newK == 1) return Pair(node, 0)
        return inOrderTraversalKthElement(node.right, newK - 1)
    }
}