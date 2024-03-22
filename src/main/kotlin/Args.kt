package org.kata

import org.yaml.snakeyaml.LoaderOptions
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import java.io.File

class Args(private val schema: Schema) {
    companion object {
        val knownParsers: Map<String, ArgumentParser> = mutableMapOf(
            Pair("int", IntegerParser()),
            Pair("flag", FlagParser()),
            Pair("string", StringParser()),
        ).apply {
            keys.toList().filter{ this[it]!!.hasArgumentValue }.forEach {
                put("list_$it", ListParser(this[it]!!))
            }
        }
    }
    fun runWith(input: String): Map<String, Any> {
        val parsed = mutableMapOf<String, Any>()

        input.split(" ").filter { it != "" }.let {
            var currentIndex = 0
            while (currentIndex <= it.lastIndex) {
                val argName = it[currentIndex].substring(1)
                val argSchema = schema.args[argName]!!
                val parser = argSchema.getArgumentParser()

                if (parser.hasArgumentValue) {
                    parsed[argName] = parser.parse(it[currentIndex + 1])
                    currentIndex++
                } else {
                    parsed[argName] = parser.parse("")
                }

                currentIndex++
            }
        }

        schema.args.filterNot { parsed.containsKey(it.key) }
            .forEach { parsed[it.key] = it.value.getArgumentParser().defaultValue }

        return parsed
    }

    class Schema(var args: Map<String, SchemaArgument> = mapOf()) {
        companion object {
            fun fromFile(file: File): Schema {
                val yaml = Yaml(Constructor(Schema::class.java, LoaderOptions()))
                return yaml.load(file.inputStream())
            }
        }

        class SchemaArgument(var type: String = "") {
            var description: String = ""
            fun getArgumentParser(): ArgumentParser {
                if (type == "") throw Error("No type given") else return knownParsers[type]!!
            }
        }
    }
}

interface ArgumentParser {
    fun parse(value: String): Any
    val defaultValue: Any
    val hasArgumentValue: Boolean
}

class IntegerParser: ArgumentParser {
    override fun parse(value: String): Any = value.toInt()
    override val hasArgumentValue: Boolean = true
    override val defaultValue: Any = 0
}

class FlagParser: ArgumentParser {
    override fun parse(value: String): Any = true
    override val hasArgumentValue: Boolean = false
    override val defaultValue: Any = false
}

class StringParser: ArgumentParser {
    override fun parse(value: String): Any = value
    override val hasArgumentValue: Boolean = true
    override val defaultValue: Any = ""
}

class ListParser(private val elementParser: ArgumentParser): ArgumentParser {
    override fun parse(value: String): Any = value.split(",").map { elementParser.parse(it) }
    override val hasArgumentValue: Boolean = true
    override val defaultValue: Any = emptyList<Any>()
}