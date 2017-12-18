package Expresions

import machine.DataMemory
import machine.ProgramMemory

internal class ID(var name: String) : Expression {
    override fun toOpcodes() {
        val addr = DataMemory.push(name)
        ProgramMemory.push("PUSH $$$addr")
    }
}