package CodeWars.AllInclusive

fun main(){
    println(test("bsjq", arrayListOf("bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs")))
}

//better way to do this...
fun test(s: String, arr: ArrayList<String>): Boolean {
    return arr.containsAll(List(s.length){s.drop(it) + s.take(it)})
}

fun containAllRots(strng: String, arr: ArrayList<String>): Boolean{

    var chars = strng.toCharArray()
    val swap = {c: CharArray ->
            var newArray = c.copyOfRange(1,c.size)
            newArray += c.first()
            newArray
        }

    val rots = arrayListOf<String>()
    for (i in 0 until strng.length){
        rots.add(String(chars))
        chars = swap(chars)
    }

    return arr.containsAll(rots)
}