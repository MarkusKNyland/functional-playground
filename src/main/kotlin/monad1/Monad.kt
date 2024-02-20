package monad1

fun square(x: Int): Int {
    return x * x
}

fun addOne(x: Int): Int {
    return x + 1
}

fun main() {
    println(addOne(square(2)))
}
