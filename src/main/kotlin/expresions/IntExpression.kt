package expresions

import machine.ProgramMemory

internal class IntExpression(var value: Int) : Expression {

    override fun toOpcodes() {
        ProgramMemory.push("PUSH $value")
    }
}
