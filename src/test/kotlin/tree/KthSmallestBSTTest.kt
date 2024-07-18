package tree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.tree.KthSmallestBST
import org.kata.tree.TreeNode

class KthSmallestBSTTest {
    @TestFactory
    fun getKthSmallest() = listOf(
        Pair(TreeNode(0), 1) to 0,
        Pair(
            TreeNode(
                8, TreeNode(3, TreeNode(1), TreeNode(6, TreeNode(4), TreeNode(7))),
                TreeNode(10, null, TreeNode(14, TreeNode(13)))
            ),
            4,
        ) to 6,
        Pair(
            TreeNode(5, TreeNode(2, TreeNode(1)), TreeNode(6)),
            3,
        ) to 5,
        Pair(
            TreeNode(1, null, TreeNode(3, TreeNode(2))),
            2,
        ) to 2,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Gets ${input.second}th smallest of ${input.first.print()}") {
            val (root, k) = input
            val output = KthSmallestBST.get(root, k)
            Assertions.assertEquals(expected, output)
        }
    }
}