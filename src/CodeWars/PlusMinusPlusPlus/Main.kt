package CodeWars.PlusMinusPlusPlus

import CodeWars.MexicanWave.basicTests
import kotlin.test.assertEquals

fun main() {
    `Basic Tests`()
}

fun getSolution(arr: IntArray, sum: Int): Boolean {
    return recurse(arr, sum)
}

fun recurse(arr: IntArray, sum: Int): Boolean {
    if (arr.isEmpty())
    {
        if (sum == 0)
            return true
        else
            return false
    }

    val plus = recurse(arr.drop(1).toIntArray(), sum - arr.get(0))
    val minus = recurse(arr.drop(1).toIntArray(), sum + arr.get(0))

    if (plus || minus) return true else return false
}

fun `Basic Tests`() {
//    assertEquals(true, getSolution(intArrayOf(1, 3, 4, 6, 8), -2))
//    assertEquals(true, getSolution(intArrayOf(15, 2, 3), 10))
    assertEquals(false, getSolution(intArrayOf(1, 5, 3, 2, 5), -2))
}