package CodeWars.IsHeGonnaSurvive


fun main()
{
    println(hero(7, 4))
}

fun hero(bullets: Int, dragons: Int): Boolean {
    return (bullets/2) >= dragons
}
