package CodeWars.CountingDuplicates

fun main()
{
    println(duplicateCount("abcde"))
    println(duplicateCount2("aabBcde"))
    println(duplicateCount2("indivisibility"))
}

fun duplicateCount(text: String): Int {
    val cleanString = text.toLowerCase()
    val charSet: MutableSet<Char> = mutableSetOf()
    val dupeSet: MutableSet<Char> = mutableSetOf()

    for (s in cleanString)
    {
        if (s in charSet)
            dupeSet.add(s)
        else
            charSet.add(s)
    }

    return dupeSet.size
}

fun duplicateCount2(text: String): Int {
    return text.groupBy{it.toLowerCase()}.count { it.value.size > 1 }
}