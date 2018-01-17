package Instuctions

import Expresions.Expression
import machine.ProgramMemory

internal class WhileInstruction(var condition: Expression, var simpleInstruction: SimpleInstruction) : WhileInstructionI {
    override fun toOpcodes() {
        val condAddress = ProgramMemory.nextAddress
        condition.toOpcodes()
        val toOverride = ProgramMemory.push("")
        simpleInstruction.toOpcodes()
        ProgramMemory.push("JMP $$condAddress")
        val nopAddress = ProgramMemory.push("NOP")
        ProgramMemory.override(toOverride, "JZ $$nopAddress")
    }
}