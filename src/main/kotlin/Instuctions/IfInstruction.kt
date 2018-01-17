package Instuctions

import Expresions.Expression
import machine.ProgramMemory
import java.util.HashMap

internal class IfInstruction(var condition: Expression, var simpleInstruction: SimpleInstruction) : IfInstructionI {

    override fun toOpcodes() {
        condition.toOpcodes()
        val toOverride = ProgramMemory.push("")
        simpleInstruction.toOpcodes()
        val nopAddress = ProgramMemory.push("NOP")
        ProgramMemory.override(toOverride, "JZ $$nopAddress")
    }
}