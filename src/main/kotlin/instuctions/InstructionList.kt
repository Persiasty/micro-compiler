package instuctions

import java.util.ArrayList

class InstructionList(s: SimpleInstruction) {
    private val simpleInstructions: MutableList<SimpleInstruction>

    init {
        simpleInstructions = ArrayList()
        simpleInstructions.add(s)
    }

    fun add(s: SimpleInstruction) {
        simpleInstructions.add(s)
    }

    fun toOpcodes() {
        for (si in simpleInstructions) {
            si.toOpcodes()
        }
    }
}