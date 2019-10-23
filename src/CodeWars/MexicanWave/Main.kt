package CodeWars.MexicanWave

import java.util.regex.Pattern
import kotlin.test.assertEquals

fun main() {

    basicTests()
}

fun wave(str: String): List<String> {

    val answer = mutableListOf<String>()
    val regex = Pattern.compile("[a-z]")

    for (i in 0..str.length-1) {
        if (regex.matcher(str.get(i).toString()).matches()) {
            answer.add(str.replaceRange(i, i+1, str.get(i).toUpperCase().toString()))
        }
    }

    return answer
}

fun basicTests() {
    assertEquals(listOf("A       b    ", "a       B    "), wave("a       b    "))
    assertEquals(listOf("This is a few words", "tHis is a few words", "thIs is a few words", "thiS is a few words", "this Is a few words", "this iS a few words", "this is A few words", "this is a Few words", "this is a fEw words", "this is a feW words", "this is a few Words", "this is a few wOrds", "this is a few woRds", "this is a few worDs", "this is a few wordS"), wave("this is a few words"))
    assertEquals(listOf<String>(), wave(""))
    assertEquals(listOf(" Gap ", " gAp ", " gaP "), wave(" gap "))
}