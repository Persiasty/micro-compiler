import Instuctions.InstructionList
import machine.ProgramMemory
import java.io.*
import java.util.*

fun main(argv: Array<String>) {
    try {
        val s = Symbols()
        val p = Parser(Lexer(FileReader(argv[0])))
        val result = p.parse().value
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

class Main(private val instructionList: InstructionList) {
    fun show() {
        instructionList.toOpcodes()
        ProgramMemory.print(System.out)
    }
}