package expresions

internal class PIntExpression(var expr: Expression) : Expression {
    override fun toOpcodes() {
        expr.toOpcodes()
    }
}