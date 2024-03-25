package org.kata

data class AccountNumber(val number: String) {
    fun validateChecksum(): Boolean {
        val checksum = number.foldIndexed(0) { index, acc, num ->
            val multiplier = number.length - index
            acc + num.digitToInt() * multiplier
        }

        return checksum % 11 == 0
    }
}