package Operators

import Expresions.Expression
import machine.ProgramMemory

internal class PlusOperator : Operator {
    override fun toOpcodes(e1: Expression, e2: Expression) {
        e1.toOpcodes()
        e2.toOpcodes()
        ProgramMemory.push("ADD")
    }
}