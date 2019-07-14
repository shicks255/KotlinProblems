package CodeWars.CountOfPositivesSumOfNegatives


fun main()
{
    println(countPositivesSumNegatives(arrayOf(0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14)))
}

fun countPositivesSumNegatives(input: Array<Int>): Array<Int> {
    val pair = input.filter { it != 0 }.partition { it >= 0 }

    val positives = pair.first.size
    val sumNegs = pair.second.reduce { acc, i -> acc + i }

    return arrayOf(positives, sumNegs)
}