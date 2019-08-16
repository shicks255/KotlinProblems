package CodeWars.FindTheParityOutlier

import kotlin.test.assertEquals

fun find(integers: Array<Int>): Int {


    val evens = integers.map { Math.abs(it) }.count { it % 2 == 0 }
    val odds = integers.map { Math.abs(it) }.count { it % 2 == 1}

    when {
        evens == 1 -> return integers.get(integers.map{Math.abs(it)}.indexOfFirst{ it % 2 == 0 }!!)
        odds == 1 ->  return integers.get(integers.map { Math.abs(it) }.indexOfFirst {it % 2 == 1}!!)
    }

    return 0
}

fun main()
{
    val exampleTest1 = arrayOf(2,6,8,-10,3)
    val exampleTest2 = arrayOf(206847684,1056521,7,17,1901,21104421,7,1,35521,1,7781)
    val exampleTest3 = arrayOf(Integer.MAX_VALUE, 0, 1)

    assertEquals(3, find(exampleTest1))
    assertEquals(206847684, find(exampleTest2))
    assertEquals(0, find(exampleTest3))
}