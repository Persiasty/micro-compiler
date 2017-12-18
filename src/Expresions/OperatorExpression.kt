package Expresions

import Operators.Operator

internal class OperatorExpression(var e: Expression, var o: Operator, var e2: Expression) : Expression {
    override fun toOpcodes() {
        o.toOpcodes(e, e2)
    }

}