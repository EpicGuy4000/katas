package org.kata

class Int32ToIpv4 {
    companion object {
        fun convert(input: UInt): String = listOf(
            input / 256u / 256u / 256u,
            input / 256u / 256u % 256u,
            input / 256u % 256u,
            input % 256u
        ).joinToString(".")
    }
}