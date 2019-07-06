package CodeWars.StringRepeat

fun main(){
    print(repeatStr(5, "HiHowAreYa"))
}

fun repeatStr(r: Int, str: String): String {
    val value = StringBuilder()

    for (s in 1..r)
        value.append(str)

    return value.toString()
}