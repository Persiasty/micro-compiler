package expresions

import machine.ProgramMemory

internal class BooleanExpression(var value: Boolean) : Expression {
    override fun toOpcodes() {
        ProgramMemory.push("PUSH ${if (value) 1 else 0}")
    }
}
