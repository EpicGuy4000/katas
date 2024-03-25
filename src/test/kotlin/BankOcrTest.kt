import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

import org.kata.BankOcr
import java.io.File

class BankOcrTest {
    @Test
    fun oneToNine_areParsedCorrectly() {
        val scanResult = BankOcr.scan(File(ArgsTest::class.java.getResource("examples/bankOcr/1to9.txt")!!.toURI()).readLines())
        assertEquals("123456789", scanResult.number)
    }

    @Test
    fun oneToNine_checksumCheckSuccess() {
        val scanResult = BankOcr.scan(File(ArgsTest::class.java.getResource("examples/bankOcr/1to9.txt")!!.toURI()).readLines())
        assertTrue(scanResult.validateChecksum())
    }

    @Test
    fun oneToEightAndOne_checksumCheckFails() {
        val scanResult = BankOcr.scan(File(ArgsTest::class.java.getResource("examples/bankOcr/1to8and1.txt")!!.toURI()).readLines())
        assertFalse(scanResult.validateChecksum())
    }

    @Test
    fun oneToNine_isNotIllegible() {
        val scanResult = BankOcr.scan(File(ArgsTest::class.java.getResource("examples/bankOcr/1to9.txt")!!.toURI()).readLines())
        assertFalse(scanResult.isIllegible())
    }

    @Test
    fun oneToNineIllegible_isIllegible() {
        val scanResult = BankOcr.scan(File(ArgsTest::class.java.getResource("examples/bankOcr/1to9_illegible.txt")!!.toURI()).readLines())
        assertTrue(scanResult.isIllegible())
    }

    @Test
    fun report_printsInExpectedFormat() {
        assertEquals("123456789\n" +
                "123456781 ERR\n" +
                "1234567?9 ILL", listOf(
            "examples/bankOcr/1to9.txt",
            "examples/bankOcr/1to8and1.txt",
            "examples/bankOcr/1to9_illegible.txt",
        ).map { File(ArgsTest::class.java.getResource(it)!!.toURI()).readLines() }
            .map(BankOcr.Companion::scan)
            .map { it.print() }.joinToString("\n"))

    }
}