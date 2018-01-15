package Conditions

import Expresions.Expression
import machine.ProgramMemory

internal class GeCond: Condition {
    override fun toOpcodes() {
        val nextAddress = ProgramMemory.nextAddress
        ProgramMemory.push("JGEZ $${nextAddress + 3}")
        super.toOpcodes()
    }

}