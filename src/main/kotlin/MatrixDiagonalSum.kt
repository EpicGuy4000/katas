package org.kata

class MatrixDiagonalSum {
    companion object {
        fun getDiagonalSum(matrix: Array<Array<Int>>): Int = matrix
            .withIndex()
            .sumOf { (ri, row) -> row
                .withIndex()
                .sumOf { (ci, column) -> if (ri == ci || ri == matrix.lastIndex - ci) column else 0 } }
    }
}