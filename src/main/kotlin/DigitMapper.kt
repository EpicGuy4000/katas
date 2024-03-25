package org.kata

class DigitMapper {
    companion object {
        val map: Map<String, String> = mapOf(
            Pair(   "   \n" +
                    "  |\n" +
                    "  |", "1"),
            Pair(   " _ \n" +
                    " _|\n" +
                    "|_ ", "2"),
            Pair(   " _ \n" +
                    " _|\n" +
                    " _|", "3"),
            Pair(   "   \n" +
                    "|_|\n" +
                    "  |", "4"),
            Pair(   " _ \n" +
                    "|_ \n" +
                    " _|", "5"),
            Pair(   " _ \n" +
                    "|_ \n" +
                    "|_|", "6"),
            Pair(   " _ \n" +
                    "  |\n" +
                    "  |", "7"),
            Pair(   " _ \n" +
                    "|_|\n" +
                    "|_|", "8"),
            Pair(   " _ \n" +
                    "|_|\n" +
                    " _|", "9"),
        )
    }
}