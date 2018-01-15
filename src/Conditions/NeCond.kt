package Conditions

import Expresions.Expression
import machine.ProgramMemory

internal class NeCond : Condition {
    override fun toOpcodes() {
        val nextAddress = ProgramMemory.nextAddress
        ProgramMemory.push("JNZ $${nextAddress + 3}")
        super.toOpcodes()
    }

}