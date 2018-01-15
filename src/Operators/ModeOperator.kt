package Operators

import Expresions.Expression
import machine.ProgramMemory

internal class ModeOperator : Operator {
    override fun toOpcodes(e1: Expression, e2: Expression) {
        e1.toOpcodes()
        e2.toOpcodes()
        e1.toOpcodes()
        e2.toOpcodes()
        ProgramMemory.push("DIV")
        ProgramMemory.push("MUL")
        ProgramMemory.push("NEG")
        ProgramMemory.push("ADD")
    }
}