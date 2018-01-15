package Conditions

import Expresions.Expression
import machine.ProgramMemory

internal class EqCond : Condition {
    override fun toOpcodes() {
        val nextAddress = ProgramMemory.nextAddress
        ProgramMemory.push("JZ $${nextAddress + 3}")
        super.toOpcodes()
    }
}