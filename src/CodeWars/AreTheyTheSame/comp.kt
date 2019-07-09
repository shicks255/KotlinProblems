package CodeWars.AreTheyTheSame

fun main()
{
    val a1 = intArrayOf(121, 144, 19, 161, 19, 144, 19, 11)
    val a2 = intArrayOf(11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19)
    println(comp(a1, a2))
}

fun comp(a: IntArray?, b: IntArray?): Boolean{
    when {
        a == null || b == null -> return false
        a.size != b.size -> return false
        else -> {
            val squared = a.map {x  -> x*x}
            return squared.sorted() == b.sorted()
        }
    }
}