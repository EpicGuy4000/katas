package org.kata

typealias AccountNumber = String

class BankOcr {
    companion object {
        fun scan(lines: List<String>): AccountNumber {
            if (lines.isEmpty()) return ""

            val digits: MutableList<String> = mutableListOf()
            for (i in 0..<lines[0].length.div(3)) {
                val digitAsString = List(3) {
                    lines[it].substring((i * 3)..(i * 3 + 2))
                }.joinToString("\n")
                println("Trying to map $digitAsString")
                digits.add(DigitMapper.map[digitAsString]!!)
            }

            return digits.joinToString("")
        }
    }
}
