package Instuctions

import Expresions.Expression
import machine.DataMemory
import machine.ProgramMemory

class ReadInstruction(val name: String) : SimpleInstruction {
    override fun toOpcodes() {
        ProgramMemory.push("READ")
        val addr = DataMemory.push(name)
        ProgramMemory.push("POP $$$addr")
    }
}