package CodeWars.ReturnNegative

fun main()
{
    println(makeNegative(-5))
}

fun makeNegative(x: Int): Int {
    return -Math.abs(x)
}