package CodeWars.Meeting

fun main()
{
    println(meeting("Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn"))
    println(meeting("John:Gates;Michael:Wahl;Megan:Bell;Paul:Dorries;James:Dorny;Lewis:Steve;Alex:Meta;Elizabeth:Russel;Anna:Korn;Ann:Kern;Amber:Cornwell"))
    println(meeting("Alex:Arno;Alissa:Cornwell;Sarah:Bell;Andrew:Dorries;Ann:Kern;Haley:Arno;Paul:Dorny;Madison:Kern"))
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

    return sortedNames.map { x: Tuple -> "(${x.b}, ${x.a})"  }
        .reduce { acc, str ->  acc + str}
}