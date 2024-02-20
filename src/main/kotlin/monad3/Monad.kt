package monad3

data class ResultWithLogs(val result: Int, val logs: List<String>)

fun wrapToResultWithLogs(x: Int): ResultWithLogs {
    return ResultWithLogs(
        result = x,
        logs = emptyList()
    )
}

fun square(r: ResultWithLogs): ResultWithLogs {
    return ResultWithLogs(
        result = r.result * r.result,
        logs = r.logs + "Squared ${r.result} to get ${r.result * r.result}"
    )
}

fun addOne(r: ResultWithLogs): ResultWithLogs {
    return ResultWithLogs(
        result = r.result + 1,
        logs = r.logs + "Added 1 to ${r.result} to get ${r.result + 1}"
    )
}

fun main() {
    println(addOne(square(wrapToResultWithLogs(2))))
    println(square(square(wrapToResultWithLogs(2))))
    println(addOne(wrapToResultWithLogs(5)))
}

// issue 2
// repeterende kode i hver funksjon
