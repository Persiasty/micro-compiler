package Expresions

internal class PBooleanExpression(var expr: Expression) : Expression {
    override fun toOpcodes() {
        expr.toOpcodes()
    }
}
