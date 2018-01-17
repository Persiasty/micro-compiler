package instuctions

import expresions.Expression
import machine.ProgramMemory

internal class IfInstruction(var condition: Expression, var simpleInstruction: SimpleInstruction) : IfInstructionI {

    override fun toOpcodes() {
        condition.toOpcodes()
        val toOverride = ProgramMemory.push("")
        simpleInstruction.toOpcodes()
        val nopAddress = ProgramMemory.push("NOP")
        ProgramMemory.override(toOverride, "JZ $$nopAddress")
    }
}