package conditions

import machine.ProgramMemory

class Condition(val conditionOp: String) {
    fun toOpcodes() {
        val nextAddress = ProgramMemory.nextAddress
        ProgramMemory.push("$conditionOp $${nextAddress + 3}")
        val jmpAddress = ProgramMemory.push("PUSH 0")
        ProgramMemory.push("JMP $${jmpAddress + 3}")
        ProgramMemory.push("PUSH 1")
        ProgramMemory.push("NOP")
    }
}