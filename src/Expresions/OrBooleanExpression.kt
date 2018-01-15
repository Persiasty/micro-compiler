package Expresions

import machine.ProgramMemory

internal class OrBooleanExpression(var expr: Expression, var expr2: Expression) : Expression {
    override fun toOpcodes() {
        expr.toOpcodes()
        expr2.toOpcodes()
        ProgramMemory.push("ADD")
        val jgzAddress = ProgramMemory.nextAddress + 3
        val toOverride = ProgramMemory.push("JGZ $$jgzAddress")
        ProgramMemory.push("PUSH 0")
        ProgramMemory.push("JMP $${jgzAddress + 1}")
        ProgramMemory.push("PUSH 1")
        ProgramMemory.push("NOP")
    }
}