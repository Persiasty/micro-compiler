package Instuctions

import Expresions.Expression

internal class IfElseInstruction(
        var condition: Expression,
        var simpleInstruction: SimpleInstruction,
        var simpleInstruction2: SimpleInstruction
) : IfInstructionI {
    override fun toOpcodes() {
        TODO()
    }


}