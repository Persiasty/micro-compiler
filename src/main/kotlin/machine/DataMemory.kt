package machine

object DataMemory {
    private val mapping: MutableMap<String, Long> = HashMap()
    private var maxAddress = 0L
    private val nextAddress get() = maxAddress++

    fun push(name: String): Long = mapping.getOrPut(name, { nextAddress })
}