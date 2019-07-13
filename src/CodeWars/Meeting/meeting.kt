package CodeWars.Meeting

fun main()
{
    println(meeting("Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill"))
}

fun meeting(s: String): String {

    data class Tuple(val a: String, val b: String): Comparable<Tuple>
    {
        override fun compareTo(other: Tuple): Int {
            if (this.b != other.b)
                return this.b.compareTo(other.b)
            else
                return this.a.compareTo(other.a)
        }
    }

    val namesList: List<Tuple> = s.split(";").map { x ->
        val y = x.split(":")
        Tuple(y[0].toUpperCase(), y[1].toUpperCase())
    }

    val sortedNames: List<Tuple> =
        namesList.sorted()

    return sortedNames.map { x: Tuple -> "(${x.a}, ${x.b})"  }
        .reduce { acc, s ->  acc + s}
}