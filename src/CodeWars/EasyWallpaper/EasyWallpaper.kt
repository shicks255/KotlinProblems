package CodeWars.EasyWallpaper


fun wallpaper(l:Double, w:Double, h:Double): String {
    val wallpaperWidth = .52
    val wallpaperLength = 10

    val total = (l*w*h) * 1.15

    val wallpaperTotal = wallpaperLength*wallpaperWidth

    val rolls = Math.ceil(total/wallpaperTotal)

    return rolls.toString()
}

fun main() {

    println(wallpaper(4.0,3.5,3.0))
    println(wallpaper(0.0,3.5,3.0))

}