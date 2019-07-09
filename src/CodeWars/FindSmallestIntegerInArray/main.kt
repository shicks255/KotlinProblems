package CodeWars.FindSmallestIntegerInArray


fun main()
{
    val smallestFinder = SmallestIntegerFinder()

    val smallest = smallestFinder.findSmallestInt(listOf(34, 15, 88, 2))
    println(smallest)
}