package org.kata.matrix

class RichestCustomerWealth {
    companion object {
        fun getMostWealth(matrix: Array<Array<Int>>): Int = matrix.maxOf { row -> row.sum() }
    }
}