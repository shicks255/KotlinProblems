package CodeWars.TrickyKotlin4PreventStackOverflow

import java.util.*

fun main()
{

}

tailrec fun loop(random: Random, int: Int): Int {
    if (int <= 0) return random.nextInt()
    else {
        random.nextInt()
        return loop(random, int-1)
    }
}