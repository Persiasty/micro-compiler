package instuctions

import expresions.Expression
import machine.ProgramMemory

internal class OutputInstruction(val expr: Expression) : SimpleInstruction {
    override fun toOpcodes() {
        expr.toOpcodes()
        ProgramMemory.push("PRINT")
    }
}
