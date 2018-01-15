package Instuctions

import Expresions.Expression
import machine.DataMemory
import machine.ProgramMemory

internal class AssignInstruction(var name: String, var value: Expression) : SimpleInstruction {
    override fun toOpcodes() {
        value.toOpcodes()
        val addr = DataMemory.push(name)
        ProgramMemory.push("POP $$addr")
    }
}