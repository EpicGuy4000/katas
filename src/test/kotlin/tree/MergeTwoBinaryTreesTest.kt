package tree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.kata.tree.MergeTwoBinaryTrees
import org.kata.tree.TreeNode

class MergeTwoBinaryTreesTest {
    @TestFactory
    fun mergeTrees() = listOf(
        Pair(null, null) to null,
        Pair(TreeNode(0), TreeNode(0)) to TreeNode(0),
        Pair(
            TreeNode(1, TreeNode(3), TreeNode(2)),
            TreeNode(1, TreeNode(2), TreeNode(3))
        )
                to TreeNode(2, TreeNode(5), TreeNode(5)),
        Pair(
            TreeNode(5, TreeNode(4), TreeNode(7)),
            TreeNode(3, TreeNode(2), TreeNode(6))
        )
                to TreeNode(8, TreeNode(6), TreeNode(13)),
        Pair(
            TreeNode(2, null, TreeNode(5)),
            TreeNode(2, TreeNode(3))
        )
                to TreeNode(4, TreeNode(3), TreeNode(5)),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("Merges trees ${input.first?.print()} and ${input.second?.print()}") {
            val output = MergeTwoBinaryTrees.merge(input.first, input.second)
            Assertions.assertEquals(expected, output)
        }
    }
}