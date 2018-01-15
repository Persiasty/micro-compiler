package Conditions

import Expresions.Expression
import machine.ProgramMemory

import java.util.HashMap

interface Condition {
    fun toOpcodes() {
        val jmpAddress = ProgramMemory.push("PUSH 0")
        ProgramMemory.push("JMP $${jmpAddress + 3}")
        ProgramMemory.push("PUSH 1")
        ProgramMemory.push("NOP")
    }
}