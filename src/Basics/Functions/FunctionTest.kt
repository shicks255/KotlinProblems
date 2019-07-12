package Basics.Functions

fun main()
{
    println(nonGenericFunction("hi"))
    val testString = "test"
    println(testString.stringSize())
    println(makeGenericFunction(25, {x -> x*2}))
    println(makeGenericFunction("Steve", {x -> x.reversed()}))
}

val nonGenericFunction: ((s: String) -> Int) = {s ->  s.length}
fun <T,R> makeGenericFunction(t: T, fn:(T)->R): R{
    return fn(t)
}
fun String.stringSize(): Int = this.length