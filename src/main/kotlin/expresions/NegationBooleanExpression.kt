package expresions

import machine.ProgramMemory

internal class NegationBooleanExpression(var expr: Expression) : Expression {
    override fun toOpcodes() {
        expr.toOpcodes()
        val addr = ProgramMemory.nextAddress
        ProgramMemory.push("JZ $${addr + 3}")
        ProgramMemory.push("PUSH 0")
        ProgramMemory.push("JMP $${addr + 5}")
        ProgramMemory.push("PUSH 1")
        ProgramMemory.push("NOP")

    }
}