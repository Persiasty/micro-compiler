package Conditions

import Expresions.Expression
import machine.ProgramMemory

internal class GtCond : Condition {
    override fun toOpcodes() {
        val nextAddress = ProgramMemory.nextAddress
        ProgramMemory.push("JGZ $${nextAddress + 3}")
        super.toOpcodes()
    }

}