package org.kata.tree

class RangeSumBST(private val root: TreeNode?, private val low: Int, private val high: Int) {
    fun getRangeSum(): Int = inOrderTraversalSum(root)

    private fun inOrderTraversalSum(
        node: TreeNode?
    ): Int {
        if (node == null) return 0

        var sum = 0

        if (node.value > low) sum += inOrderTraversalSum(node.left)
        if (node.value in low..high) sum += node.value
        if (node.value < high) sum += inOrderTraversalSum(node.right)

        return sum
    }
}