package instuctions

import expresions.Expression
import machine.ProgramMemory

internal class DoWhileInstruction(var condition: Expression, var simpleInstruction: SimpleInstruction) : WhileInstructionI {
    override fun toOpcodes() {
        val nopAddress = ProgramMemory.push("NOP")
        simpleInstruction.toOpcodes()
        condition.toOpcodes()
        ProgramMemory.push("JNZ $$nopAddress")
    }
}
