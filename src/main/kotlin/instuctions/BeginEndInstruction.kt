package instuctions

internal class BeginEndInstruction(val instructionList: InstructionList) : SimpleInstruction {
    override fun toOpcodes() {
        instructionList.toOpcodes()
    }
}