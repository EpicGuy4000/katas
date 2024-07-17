package tree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.tree.MinimumDifferenceInBST
import org.kata.tree.TreeNode

class MinimumDifferenceInBSTTest {
    @TestFactory
    fun calculatesMaximumHeight() = listOf(
        null to 0,
        TreeNode(0) to 0,
        TreeNode(4, TreeNode(2, TreeNode(1), TreeNode(3)), TreeNode(6)) to 1,
        TreeNode(10, TreeNode(5, TreeNode(2), TreeNode(7)), TreeNode(15, null, TreeNode(18))) to 2,
        TreeNode(40, null, TreeNode(70, TreeNode(50), TreeNode(90))) to 10,
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Calculates that minimum difference between nodes of \n${input?.print()}\n") {
            val output = MinimumDifferenceInBST.calculate(input)
            Assertions.assertEquals(expected, output)
        }
    }
}