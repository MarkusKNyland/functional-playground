package monad4

data class ResultWithLogs(val result: Int, val logs: List<String>)

fun wrapToResultWithLogs(x: Int): ResultWithLogs {
    return ResultWithLogs(
        result = x,
        logs = emptyList()
    )
}

fun runWithLogs(input: ResultWithLogs, transform: (x: Int) -> ResultWithLogs): ResultWithLogs {
    val newResultWithLogs = transform(input.result)

    return ResultWithLogs(
        result = newResultWithLogs.result,
        logs = input.logs + newResultWithLogs.logs
    )
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
    val wrappedValue = wrapToResultWithLogs(2)

//    println(runWithLogs(wrappedValue) { x -> addOne(x) })
    println(runWithLogs(wrappedValue, ::addOne))

    println(
        runWithLogs(
            runWithLogs(wrappedValue, ::square),
            ::addOne
        )
    )

    println(runWithLogs(runWithLogs(wrappedValue, ::square), ::square))
}
