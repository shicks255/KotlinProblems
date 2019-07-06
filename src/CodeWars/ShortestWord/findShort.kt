package CodeWars.ShortestWord

fun main()
{
    print(findShort("Today is a nice day"))
}

fun findShort(s: String): Int{
    val answer: Int? = s.split(" ").map { x -> x.length }.min()

    when (answer) {
        is Int -> return answer
        else -> return 0
    }
}