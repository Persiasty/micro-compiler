import instuctions.ExitInstruction
import instuctions.InstructionList
import machine.ProgramMemory
import java.io.*

@Suppress("DEPRECATION")
fun main(argv: Array<String>) {
    try {
        val lexer = Lexer(InputStreamReader(System.`in`))
        val parser = Parser(lexer)
        parser.parse()
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

class Main(private val instructionList: InstructionList) {
    fun show() {
        instructionList.toOpcodes()
        ExitInstruction().toOpcodes()
        ProgramMemory.print(System.out, true)
    }
}