package expresions

import machine.ProgramMemory

internal class UMinusExpression(var value: Long) : Expression {
    override fun toOpcodes() {
        ProgramMemory.push("PUSH $value")
        ProgramMemory.push("NEG")
    }

}