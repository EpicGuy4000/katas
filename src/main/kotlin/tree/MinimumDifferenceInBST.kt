package org.kata.tree

object MinimumDifferenceInBST {
    fun calculate(root: TreeNode?): Int {
        if (root == null || (root.right == null && root.left == null)) return 0

        val (minDifference) = findMinimumDifferenceAndTrackMax(
            root,
            Pair(Int.MAX_VALUE, Int.MIN_VALUE)
        )

        return minDifference
    }

    private fun findMinimumDifferenceAndTrackMax(node: TreeNode?, state: Pair<Int, Int>): Pair<Int, Int> {
        if (node == null) return state

        var (minDifference, maxNode) = findMinimumDifferenceAndTrackMax(node.left, state)
        minDifference = minOf(
            minDifference, if (maxNode == Int.MIN_VALUE) {
                Int.MAX_VALUE
            } else {
                node.value - maxNode
            }
        )
        return findMinimumDifferenceAndTrackMax(node.right, Pair(minDifference, node.value))
    }
}