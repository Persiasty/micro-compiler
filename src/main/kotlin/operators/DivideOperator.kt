package operators

import expresions.Expression
import machine.ProgramMemory

internal class DivideOperator : Operator {
    override fun toOpcodes(e1: Expression, e2: Expression) {
        e1.toOpcodes()
        e2.toOpcodes()
        ProgramMemory.push("DIV")
    }
}