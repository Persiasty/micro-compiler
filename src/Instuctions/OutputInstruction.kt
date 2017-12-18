package Instuctions

import Expresions.Expression
import machine.ProgramMemory

internal class OutputInstruction(val expr: Expression) : SimpleInstruction {
    override fun toOpcodes() {
        expr.toOpcodes()
        ProgramMemory.push("PRINT")
    }
}
