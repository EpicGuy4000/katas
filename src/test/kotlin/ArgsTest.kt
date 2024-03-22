import org.junit.jupiter.api.Test

import org.kata.Args
import java.io.File
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class ArgsTest {

    @Test
    fun simpleSchema_noArgs_parseSuccess() {
        val args = Args(Args.Schema.fromFile(File(ArgsTest::class.java.getResource("examples/args/simpleSchema.yaml")!!.toURI())))

        val result = args.runWith("")
        assertEquals(false, result["l"])
        assertEquals(0, result["p"])
        assertEquals("", result["d"])
    }

    @Test
    fun simpleSchema_argsPassed_parseSuccess() {
        val args = Args(Args.Schema.fromFile(File(ArgsTest::class.java.getResource("examples/args/simpleSchema.yaml")!!.toURI())))

        val result = args.runWith("-l -p 123 -d value")
        assertEquals(true, result["l"])
        assertEquals(123, result["p"])
        assertEquals("value", result["d"])
    }

    @Test
    fun simpleSchema_argsWithNegativeValues_parseSuccess() {
        val args = Args(Args.Schema.fromFile(File(ArgsTest::class.java.getResource("examples/args/simpleSchema.yaml")!!.toURI())))

        val result = args.runWith("-l -p -123 -d -value-")
        assertEquals(true, result["l"])
        assertEquals(-123, result["p"])
        assertEquals("-value-", result["d"])
    }

    @Test
    fun schemaWithList_parseSuccess() {
        val args = Args(Args.Schema.fromFile(File(ArgsTest::class.java.getResource("examples/args/schemaWithList.yaml")!!.toURI())))

        val result = args.runWith("-g this,is,a,list -d 1,2,-3,5")
        assertContentEquals(arrayOf("this", "is", "a", "list").asIterable(), result["g"] as List<*>)
        assertContentEquals(arrayOf(1, 2, -3, 5).asIterable(), result["d"] as List<*>)
    }

    @Test
    fun schemaWithList_noValues_parseSuccess() {
        val args = Args(Args.Schema.fromFile(File(ArgsTest::class.java.getResource("examples/args/schemaWithList.yaml")!!.toURI())))

        val result = args.runWith("")
        assertContentEquals(emptyArray<String>().asIterable(), result["g"] as List<*>)
        assertContentEquals(emptyArray<Int>().asIterable(), result["d"] as List<*>)
    }
}