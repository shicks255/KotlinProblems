package CodeWars.SumOfPositive

fun main()
{
    print(sum(intArrayOf(1,2,5,-5)))
}

fun sum(numbers: IntArray): Int {
    return numbers
        .filter { x -> x > 0 }
        .reduce({x,y -> x+y})
}