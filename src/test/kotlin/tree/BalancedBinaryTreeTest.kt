package tree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.tree.BalancedBinaryTree
import org.kata.tree.TreeNode

class BalancedBinaryTreeTest {
    @TestFactory
    fun checkIfBalanced() = listOf(
        null to true,
        TreeNode(0) to true,
        TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7))) to true,
        TreeNode(
            1,
            TreeNode(2, TreeNode(3, TreeNode(4), TreeNode(4)), TreeNode(3)),
            TreeNode(2, TreeNode(3), TreeNode(3, TreeNode(4), TreeNode(4)))
        ) to true,
        TreeNode(1, TreeNode(2, TreeNode(3, TreeNode(4))), TreeNode(5)) to false,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Checks if \n${input?.print()}\n is balanced") {
            val output = BalancedBinaryTree.isBalanced(input)
            Assertions.assertEquals(expected, output)
        }
    }
}