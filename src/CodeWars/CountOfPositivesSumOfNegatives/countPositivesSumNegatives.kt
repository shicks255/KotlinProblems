package CodeWars.CountOfPositivesSumOfNegatives


fun main()
{
//    println(countPositivesSumNegatives(arrayOf(0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14)))
    println(countPositivesSumNegatives(arrayOf(0,0)))
}

fun countPositivesSumNegatives(input: Array<Int>?): Array<Int> {
    if (input == null || input.isEmpty())
        return arrayOf()

    val pair = input.filter { it != 0 }.partition { it >= 0 }

    val positives = pair.first.size
    val sumNegs = pair.second.run {
        when (this.size){
            0 -> 0
            else -> this.reduce { acc, i ->  acc + i}
        }
    }
    return arrayOf(positives, sumNegs)
}