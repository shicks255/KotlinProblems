package CodeWars.HighestAndLowest

fun main()
{
    print(highAndLow("1 2 3 4 5"))
}

fun highAndLow(numbers: String): String{
    val stringNumbers = numbers.split(" ")
    val numbers = stringNumbers.map { x -> x.toInt() }

    val highest = numbers.max()
    val lowest = numbers.min()
    return "$highest $lowest"
}