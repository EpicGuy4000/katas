import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

import org.kata.BankOcr
import java.io.File

class BankOcrTest {

    @Test
    fun oneToNine_areParsedCorrectly() {
        val scanResult = BankOcr.scan(File(ArgsTest::class.java.getResource("examples/bankOcr/1to9.txt")!!.toURI()).readLines())
        assertEquals("123456789", scanResult)
    }
}