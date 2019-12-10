package AdventCode2019.Day_6

import java.io.FileReader

class PlanetList() {

}

class Planet() {
    var parents = emptyList<Orbit>()
    var children = emptyList<Orbit>()
}

data class Orbit(val orbiter: String,
            val orbitee: String,
            val depth: Int)

fun main() {
//    val orbitList = getInput()
    val orbitList = listOf("COM)B",
            "B)C",
            "C)D",
            "D)E",
            "E)F",
            "B)G",
            "G)H",
            "D)I",
            "E)J",
            "J)K",
            "K)L",
            "K)YOU",
            "I)SAN")

    val orbits = mutableMapOf<String, MutableList<String>>()
    val isOrbittedBy = mutableMapOf<String, MutableList<String>>()

    orbitList.forEach{ entry ->
        val split = entry.split(")")
        val orbitee = split[0]
        val orbiter = split[1]

        if (orbits.containsKey(orbiter))
            orbits.get(orbiter)!!.add(orbitee)
        else
            orbits.put(orbiter, mutableListOf(orbitee))

        if (isOrbittedBy.containsKey(orbitee))
            isOrbittedBy.get(orbitee)!!.add(orbiter)
        else
            isOrbittedBy.put(orbitee, mutableListOf(orbiter))
    }

    var count = mutableListOf<Int>()
    for ((k,_) in isOrbittedBy)
        countOrbits(k, isOrbittedBy, count)

    //first find the a common child

    var count2 = mutableListOf<Int>()
    countPath("YOU", isOrbittedBy, orbits, count2)
    println(count.size)
}

fun countPath(start: String, isOrbitedBy: MutableMap<String, MutableList<String>>,
              orbits: MutableMap<String, MutableList<String>>,
              count: MutableList<Int>) {

    val listOfOrbited = orbits.get(start)
    if (listOfOrbited == null)
        return

    val listofIsOrbitedBy = isOrbitedBy.get(start)
    if (listOfOrbited.contains("SAN")) {
        count.add(1)
    }
    else {
        for (x in listOfOrbited) {
            count.add(1)
            countPath(x, isOrbitedBy, orbits, count)
        }
    }

}

fun countOrbits(planet: String, orbits: MutableMap<String, MutableList<String>>, count: MutableList<Int>) {

    if (!orbits.containsKey(planet) || orbits.get(planet) == null)
        return

    val listOfOrbits = orbits.get(planet)
    if (listOfOrbits != null) {
        for (x in listOfOrbits) {
            count.add(1)
            countOrbits(x, orbits, count)
        }
    }

    return
}

fun getInput(): List<String> {
    return FileReader(".\\src\\AdventCode2019\\Day_6\\input.txt").readLines()
}