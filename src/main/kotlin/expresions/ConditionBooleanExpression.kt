package expresions

import conditions.Condition
import machine.ProgramMemory

internal class ConditionBooleanExpression(var e: Expression, var c: Condition, var e2: Expression) : Expression {
    override fun toOpcodes() {
        e.toOpcodes()
        e2.toOpcodes()
        ProgramMemory.push("NEG")
        ProgramMemory.push("ADD")
        c.toOpcodes()
    }
}
