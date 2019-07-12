package CodeWars.CenturyFromYear

fun main(){
    println(century(750))
}
//should have done this much easier by division.... like ceil(number/100)

fun century(number: Int): Int {
    val str = number.toString()

    return when (str.length > 2){
        true -> {
            if (str.takeLast(2) == "00")
                if (str.length == 4)
                    str.substring(0,2).toInt()
                else
                    str.substring(0,1).toInt()
            else
                if (str.length==4)
                    str.substring(0,2).toInt()+1
                else
                    str.substring(0,1).toInt()+1
        }
        else -> 1
    }
}