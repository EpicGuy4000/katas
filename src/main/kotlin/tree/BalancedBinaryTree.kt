package org.kata.tree

object BalancedBinaryTree {
    fun isBalanced(root: TreeNode<*>?): Boolean {
        val (min, max) = calculateMinAndMaxHeight(root)
        return max - min <= 1
    }

    private fun calculateMinAndMaxHeight(root: TreeNode<*>?): Pair<Int, Int> {
        if (root == null) return Pair(0, 0)

        val (leftMin, leftMax) = calculateMinAndMaxHeight(root.left)
        val (rightMin, rightMax) = calculateMinAndMaxHeight(root.right)

        return Pair(minOf(leftMin, rightMin) + 1, maxOf(leftMax, rightMax) + 1)
    }
}