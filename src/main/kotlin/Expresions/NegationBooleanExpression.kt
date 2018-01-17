package Expresions

import machine.ProgramMemory

internal class NegationBooleanExpression(var expr: Expression) : Expression {
    override fun toOpcodes() {
        expr.toOpcodes()
        ProgramMemory.push("NEG")
    }
}