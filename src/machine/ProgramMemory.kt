package machine

import java.io.PrintStream

object ProgramMemory {
    private val opcodes: MutableList<String> = ArrayList()
    fun push(value: String): Int {
        val nextAddr = opcodes.size
        opcodes.add(value)
        return nextAddr
    }

    fun override(id: Int, newValue: String) {
        opcodes.set(id, newValue)
    }

    fun print(out: PrintStream) {
        opcodes.forEach {
            out.println(it)
        }
    }
}