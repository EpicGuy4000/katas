package org.kata.tree

object MaximumHeightOfBinaryTree {
    fun calculate(root: TreeNode<*>?): Int {
        if (root == null) return 0

        return maxOf(calculate(root.left), calculate(root.right)) + 1
    }
}