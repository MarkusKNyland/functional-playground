package monad2

data class ResultWithLogs(val result: Int, val logs: List<String>)

fun square(x: Int): ResultWithLogs {
    return ResultWithLogs(
        result = x * x,
        logs = listOf("Squared $x to get ${x * x}")
    )
}

fun addOne(wrap: ResultWithLogs): ResultWithLogs {
    return ResultWithLogs(
        result = wrap.result + 1,
        logs = wrap.logs + "Added 1 to ${wrap.result} to get ${wrap.result + 1}"
    )
}

fun main() {
    // Funker, men er lite anvendelig
    println(addOne(square(2)))
    //println(square(square(2)))
    //println(addOne(5))
}
