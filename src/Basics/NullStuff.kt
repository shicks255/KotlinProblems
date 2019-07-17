package Basics

fun main()
{
    fun test(s: Int?){
        val t = s?.toString() ?: "AHHHHHHHHHHHHH"
        println(t)
    }

    var a: Int? = 26
    test(null)

    whenWithTypes(null)
}

fun whenWithTypes(a: Any?){
    when {
        a is Int -> println("it's an int ${a + 6}")
        a is String -> println("it's a string of length ${a.length}")
        else -> println("i dont know what this is")
    }
}