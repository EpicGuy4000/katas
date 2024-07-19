package org.kata.tree

object MergeTwoBinaryTrees {
    fun merge(root1: TreeNode<Int>?, root2: TreeNode<Int>?): TreeNode<Int>? {
        if (root1 == null) return root2
        if (root2 == null) return root1

        return TreeNode(
            root1.value + root2.value,
            merge(root1.left, root2.left),
            merge(root1.right, root2.right)
        )
    }
}