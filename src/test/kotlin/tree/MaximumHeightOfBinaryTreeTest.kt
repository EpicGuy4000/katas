package tree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.tree.MaximumHeightOfBinaryTree
import org.kata.tree.TreeNode

class MaximumHeightOfBinaryTreeTest {
    @TestFactory
    fun calculatesMaximumHeight() = listOf(
        null to 0,
        TreeNode(0) to 1,
        TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5)), TreeNode(3)) to 3,
        TreeNode(1, null, TreeNode(3, null, TreeNode(3))) to 3,
        TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(7, null, TreeNode(9))), TreeNode(3)) to 4,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Calculates that maximum height of \n${input?.print()}\n is a $expected") {
            val output = MaximumHeightOfBinaryTree.calculate(input)
            Assertions.assertEquals(expected, output)
        }
    }
}