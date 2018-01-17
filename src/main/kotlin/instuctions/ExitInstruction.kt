package instuctions

import machine.ProgramMemory

class ExitInstruction: SimpleInstruction {
    override fun toOpcodes() {
        ProgramMemory.push("STOP")
    }
}