package CodeWars.ComplementaryDNA

fun makeComplement(dna: String): String {
    val mapper = mapOf('A' to 'T', 'T' to 'A', 'C' to 'G', 'G' to 'C')
    return dna.map{ mapper.get(it) }.joinToString("")
}

fun main() {
    println(makeComplement("ATTGC"))
}