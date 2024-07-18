package tree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.tree.RangeSumBST
import org.kata.tree.TreeNode

class RangeSumBSTTest {
    @TestFactory
    fun getRangeSUm() = listOf(
        Triple(null, Int.MIN_VALUE, Int.MAX_VALUE) to 0,
        Triple(TreeNode(1), Int.MIN_VALUE, Int.MAX_VALUE) to 1,
        Triple(
            TreeNode(10, TreeNode(5, TreeNode(3), TreeNode(7)), TreeNode(15, null, TreeNode(18))),
            7, 15
        ) to 32,
        Triple(
            TreeNode(20, TreeNode(5, TreeNode(3), TreeNode(10)), TreeNode(25)),
            3, 10
        ) to 18,
        Triple(
            TreeNode(30, null, TreeNode(35, TreeNode(32))),
            30, 34
        ) to 62,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Gets range sum of \n${input.first?.print()}\n for range ${input.second} to ${input.third}") {
            val (root, low, high) = input
            val output = RangeSumBST(root, low, high).getRangeSum()
            Assertions.assertEquals(expected, output)
        }
    }
}