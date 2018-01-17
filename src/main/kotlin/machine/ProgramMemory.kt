package machine

import java.io.PrintStream

object ProgramMemory {
    private val opcodes: MutableList<String> = ArrayList()
    val nextAddress
        get() = opcodes.size

    fun push(value: String): Int {
        val nextAddr = nextAddress
        opcodes.add(value)
        return nextAddr
    }

    fun override(id: Int, newValue: String) {
        opcodes.set(id, newValue)
    }

    fun print(out: PrintStream) {
        opcodes.forEachIndexed { i, entry ->
            out.println("$i:\t$entry")
        }
    }
}