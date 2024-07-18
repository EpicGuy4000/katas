package org.kata.tree

import kotlin.math.abs

object ClosestBinarySearchTreeValue {
    fun getClosest(root: TreeNode<Double>, target: Double): Double {
        return findClosest(root, target, root).value
    }

    private fun findClosest(
        node: TreeNode<Double>?,
        target: Double,
        currentClosest: TreeNode<Double>
    ): TreeNode<Double> {
        if (node == null) return currentClosest

        val newClosest = let {
            if (abs(target - node.value) < abs(target - currentClosest.value)) node
            else currentClosest
        }

        if (node.value > target) return findClosest(node.left, target, newClosest)
        if (node.value < target) return findClosest(node.right, target, newClosest)

        return newClosest
    }
}