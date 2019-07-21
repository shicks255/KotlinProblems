package CodeWars.Holiday3FireOnTheBoat

fun main(){
    println(fireFight("Fire Test fire Fire"))
}

fun fireFight(s: String): String{
    return s.replace("Fire", "~~")
}