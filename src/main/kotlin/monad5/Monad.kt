package monad5

data class ResultWithLogs internal constructor(val result: Int, val logs: List<String>) {

    companion object {
        fun initialize(startingValue: Int): ResultWithLogs =
            ResultWithLogs(
                result = startingValue,
                logs = listOf("Staring with value $startingValue")
            )
    }

    fun flatMap(transform: (x: Int) -> ResultWithLogs): ResultWithLogs {
        val newResultWithLogs = transform(this.result)

        return ResultWithLogs(
            result = newResultWithLogs.result,
            logs = this.logs + newResultWithLogs.logs
        )
    }
}

fun square(x: Int): ResultWithLogs {
    return ResultWithLogs(
        result = x * x,
        logs = listOf("Squared $x to get ${x * x}")
    )
}

fun addOne(x: Int): ResultWithLogs {
    return ResultWithLogs(
        result = x + 1,
        logs = listOf("Added 1 to $x to get ${x + 1}")
    )
}

fun main() {
    println(
        ResultWithLogs.initialize(2)
            .flatMap(::square)
            .flatMap(::addOne))


}
