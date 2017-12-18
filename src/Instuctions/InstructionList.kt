package Instuctions

import java.util.ArrayList
import java.util.HashMap

class InstructionList(s: SimpleInstruction) {
    private val simpleInstructions: MutableList<SimpleInstruction>

    init {
        simpleInstructions = ArrayList()
        simpleInstructions.add(s)
    }

    fun add(s: SimpleInstruction) {
        simpleInstructions.add(s)
    }

    fun show() {
        for (si in simpleInstructions) {
            si.toOpcodes()
        }
    }
}