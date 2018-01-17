package instuctions

import expresions.Expression
import machine.ProgramMemory

internal class IfElseInstruction(
        var condition: Expression,
        var simpleInstruction: SimpleInstruction,
        var simpleInstruction2: SimpleInstruction
) : IfInstructionI {
    override fun toOpcodes() {
        condition.toOpcodes()
        val toElseOverride = ProgramMemory.push("")
        simpleInstruction.toOpcodes()
        val toOverride = ProgramMemory.push("")
        val nopElseAddress = ProgramMemory.push("NOP")
        ProgramMemory.override(toElseOverride, "JZ $$nopElseAddress")
        simpleInstruction2.toOpcodes()
        val nopAddress = ProgramMemory.push("NOP")
        ProgramMemory.override(toOverride, "JMP $$nopAddress")
    }
}