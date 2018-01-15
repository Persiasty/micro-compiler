package Conditions

import Expresions.Expression
import machine.ProgramMemory

internal class LeCond : Condition {
    override fun toOpcodes() {
        val nextAddress = ProgramMemory.nextAddress
        ProgramMemory.push("JLEZ $${nextAddress + 3}")
        super.toOpcodes()
    }

}