package tree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.tree.ClosestBinarySearchTreeValue
import org.kata.tree.TreeNode

class ClosestBinarySearchTreeValueTest {
    @TestFactory
    fun getClosest() = listOf(
        Pair(TreeNode(0.0), 1.0) to 0.0,
        Pair(
            TreeNode(
                5.0,
                TreeNode(3.0, TreeNode(1.0), TreeNode(4.0)),
                TreeNode(8.0, TreeNode(6.0), TreeNode(9.0))
            ),
            6.4,
        ) to 6.0,
        Pair(
            TreeNode(
                20.0,
                TreeNode(10.0),
                TreeNode(30.0)
            ),
            25.0,
        ) to 20.0,
        Pair(
            TreeNode(
                2.0,
                TreeNode(1.0),
                TreeNode(3.0)
            ),
            2.9,
        ) to 3.0,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Gets closest value to ${input.second} in ${input.first.print()}") {
            val (root, target) = input
            val output = ClosestBinarySearchTreeValue.getClosest(root, target)
            Assertions.assertEquals(expected, output)
        }
    }
}