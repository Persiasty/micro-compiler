package Instuctions

import Expresions.Expression

internal class WhileInstruction(var cond: Expression, var si: SimpleInstruction) : WhileInstructionI {
    override fun toOpcodes() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}