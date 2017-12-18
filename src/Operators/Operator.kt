package Operators

import Expresions.Expression
import machine.ProgramMemory

interface Operator {
    fun toOpcodes(e1: Expression, e2: Expression)
}