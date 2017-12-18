package Instuctions

import Expresions.Expression
import java.util.HashMap

internal class IfInstruction(var condition: Expression, var simpleInstruction: SimpleInstruction) : IfInstructionI {

    override fun toOpcodes() {
        TODO()
    }
}