package operators

import expresions.Expression

interface Operator {
    fun toOpcodes(e1: Expression, e2: Expression)
}