package expresions

import machine.ProgramMemory

internal class UMinusExpression(var value: Int) : Expression {
    override fun toOpcodes() {
        ProgramMemory.push("PUSH $value")
        ProgramMemory.push("NEG")
    }

}