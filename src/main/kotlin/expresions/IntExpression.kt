package expresions

import machine.ProgramMemory

internal class IntExpression(var value: Long) : Expression {

    override fun toOpcodes() {
        ProgramMemory.push("PUSH $value")
    }
}
