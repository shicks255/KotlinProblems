package CodeWars.TrickyKotlin2ThreeFundamentalFunctions

import java.lang.Exception

fun main()
{
    val bol = true

    unless(bol){println("it worked")}

    var counter = 0

    until({counter == 5}){
        println(counter)
        counter++
    }

    forceRun { throw Exception("AHHHH") }

    println("All done the functions")
}

fun until(condition: () -> Boolean, run: () -> Unit) {
    if (!condition()) {
        run()
        until(condition, run)
    }
}

fun unless(a: Boolean, arg: () -> Unit) {
    if (!a)
        arg()
}

fun forceRun(run: () -> Unit){
    try {
        run()
    }
    catch (e: Exception) {}
}