package CodeWars.GrowthOfAPopulation

fun nbYear(pp0:Int, percent:Double, aug:Int, p:Int): Int {
    var pop = pp0
    var counter = 0
    while (pop < p) {
        counter++
        pop += (pop*(percent*.01)).toInt() + aug
    }
    return counter
}

fun nbYearImproved(pp0:Int, percent: Double, aug:Int, p:Int): Int {
    return generateSequence(pp0.toDouble()){ it * (1 + percent/100) + aug }
        .takeWhile { it < p }.count()
}

fun main() {
    println(nbYearImproved(1500, 5.0, 100, 5000))
    println(nbYearImproved(1500000, 2.5, 10000, 2000000))
}