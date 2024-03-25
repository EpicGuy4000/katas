package org.kata

data class AccountNumber(val number: String) {
    fun validateChecksum(): Boolean {
        val checksum = number.foldIndexed(0) { index, acc, num ->
            val multiplier = number.length - index
            acc + num.digitToInt() * multiplier
        }

        return checksum % 11 == 0
    }

    fun isIllegible(): Boolean = number.any { it == '?' }
    fun print(): String = "$number${if(isIllegible()) " ILL" else if (!validateChecksum()) " ERR" else ""}"
}