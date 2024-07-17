package org.kata.matrix

class RowWithMaximumOnes {
    companion object {
        fun getMostOnes(matrix: Array<Array<Int>>): Pair<Int, Int> =
            matrix.withIndex()
                .maxOfWith({ p0, p1 -> p0!!.second - p1!!.second }) { (index, row) -> Pair(index, row.sum()) }
    }
}