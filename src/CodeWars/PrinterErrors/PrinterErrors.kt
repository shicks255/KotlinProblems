package CodeWars.PrinterErrors

fun printerErrors(s: String): String {
    val errors = s.count{it !in 'a'..'m'}
    return "$errors/${s.length}"
}

fun main() {
    println(printerErrors("aaabbbza"))
}