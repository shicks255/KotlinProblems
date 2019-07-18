package CodeWars.ReplaceVowelsWithExclamationMarks

fun main()
{
    println(replace("aIoUe"))
}

fun replace(s: String): String {
    val vowels = listOf('a','e','i','o','u')
    val upper = vowels.map{it.toUpperCase()}

    val answer = s.toCharArray().map {
        when {
            it in vowels || it in upper -> "!"
            else -> it
        }
    }

    return answer.joinToString("")
}