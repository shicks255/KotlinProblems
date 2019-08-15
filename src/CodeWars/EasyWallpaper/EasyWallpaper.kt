package CodeWars.EasyWallpaper

import kotlin.test.assertEquals


fun wallpaper(l:Double, w:Double, h:Double): String {
    val wallpaperWidth = .52
    val wallpaperLength = 10

    val total = (l*h*2 + w*h*2) * 1.15

    val wallpaperTotal = wallpaperLength*wallpaperWidth

    val rolls = Math.ceil(total/wallpaperTotal)

    return when (rolls.toInt()){
        0 -> "zero"
        1 -> "one"
        2 -> "two"
        3 -> "three"
        4 -> "four"
        5 -> "five"
        6 -> "six"
        7 -> "seven"
        8 -> "eight"
        9 -> "nine"
        10 -> "ten"
        11 -> "eleven"
        12 -> "twelve"
        13 -> "thirteen"
        14 -> "fourteen"
        15 -> "fifteen"
        16 -> "sixteen"
        17 -> "seventeen"
        18 -> "eighteen"
        19 -> "nineteen"
        20 -> "twenty"
        else -> ""
    }
}

fun main() {

//    println(wallpaper(4.0,3.5,3.0))
//    println(wallpaper(0.0,3.5,3.0))
//
//    assertEquals("ten", wallpaper(4.0, 3.5, 3.0))
    assertEquals("sixteen", wallpaper(6.3, 4.5, 3.29))

}