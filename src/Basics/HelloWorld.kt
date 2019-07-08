package Basics

import java.util.*

fun main(): Unit {
    println("hi")

    val steve = Person("Steve", "Hicks", 25)
    println(steve)
}

fun main2(args: Array<String>): Unit {

    println("Hello World")

    val squares = arrayOf(2,4,8,16)
    println(Arrays.toString(squares))

    val computedSquares = Array(4, {x -> (x+1)*(x+1)})
    println(Arrays.toString(computedSquares))

    val alphabet = 'a'..'z'
    println(alphabet is CharRange)

//    for (a in 'a'..'z')
//        println(a.toUpperCase())
//    for (i in 100.downTo(2).step(2).reversed())
//        println(i)
//    for (i in 10.rangeTo(20))
//        println(i)

    val stringOne = "Test"

    val stringTwo = String(charArrayOf('T', 'e', 's', 't'))
    println(stringOne == stringTwo)
    println(stringOne === stringTwo)




}
