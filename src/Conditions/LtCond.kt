package Conditions

import Expresions.Expression
import machine.ProgramMemory

internal class LtCond : Condition {
    override fun toOpcodes() {
        val nextAddress = ProgramMemory.nextAddress
        ProgramMemory.push("JLZ $${nextAddress + 3}")
        super.toOpcodes()
    }

}