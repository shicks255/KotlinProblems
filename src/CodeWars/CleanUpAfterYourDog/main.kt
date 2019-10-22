package CodeWars.CleanUpAfterYourDog

import kotlin.test.assertEquals


fun main() {

    testFixed()


}

fun crap(x: Array<CharArray>, bags: Int, cap: Int): String {
    // code here

    val crap = x.flatMap { it.map { it.toString() } }

    if (crap.contains("D"))
        return "Dog!!"
    else {
        val capacity = bags * cap

        val craps = crap.count { it == "@" }
        if (craps <= capacity)
            return "Clean"

        return "Cr@p"
    }
}

fun testFixed() {
    assertEquals("Clean", crap(arrayOf(charArrayOf('_','_','_','_'), charArrayOf('_','_','_','@'), charArrayOf('_','_','@', '_')), 2, 2))
    assertEquals("Cr@p", crap(arrayOf(charArrayOf('_','_','_','_'), charArrayOf('_','_','_','@'), charArrayOf('_','_','@', '_')), 1, 1))
    assertEquals("Dog!!", crap(arrayOf(charArrayOf('_','_'), charArrayOf('_','@'), charArrayOf('D','_')), 2, 2))
}