package expresions

import machine.ProgramMemory

internal class AndBooleanExpression(var expr: Expression, var expr2: Expression) : Expression {
    override fun toOpcodes() {
        expr.toOpcodes()
        expr2.toOpcodes()
        ProgramMemory.push("ADD")
        ProgramMemory.push("PUSH 2")
        ProgramMemory.push("NEG")
        ProgramMemory.push("ADD")
        val jgzAddress = ProgramMemory.nextAddress + 3
        ProgramMemory.push("JZ $$jgzAddress")
        ProgramMemory.push("PUSH 0")
        ProgramMemory.push("JMP $${jgzAddress + 1}")
        ProgramMemory.push("PUSH 1")
        ProgramMemory.push("NOP")
    }

}