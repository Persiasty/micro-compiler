package machine

object DataMemory {
    private val mapping: MutableMap<String, Long> = HashMap()
    private var maxAddress = 0L
    private val nextAddress get() = maxAddress++

    fun push(name: String): Long = mapping.getOrPut(name, { nextAddress })

    fun generateData(): String {
        val sb = StringBuffer("DATA ")
        mapping.forEach {
            sb.append("0, ")
        }
        sb.delete(sb.length - 2, sb.length - 1)
        return sb.toString()
    }
}