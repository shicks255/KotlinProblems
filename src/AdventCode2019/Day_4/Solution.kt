package AdventCode2019.Day_4

import java.io.FileReader

fun main() {

    val input = getInput()
    val lowAndHi = input.split("-")
    val low = lowAndHi[0].toInt()
    val high = lowAndHi[1].toInt()

    val passwords = mutableListOf<Int>()

    for (x in low..high) {
        if (ascendingOrder(x) && hasAdjacent2(x))
            passwords.add(x)
    }

    println(passwords)
    println(passwords.size)
}

fun hasAdjacent(input: Int): Boolean {
    val stringVersion = input.toString()
    stringVersion.take(5).forEachIndexed { index, char ->
        if (char == stringVersion.get(index+1))
            return true
    }
    return false
}

fun hasAdjacent2(input: Int): Boolean {
    val stringVersion = input.toString()

    val map = mutableMapOf<Char, Int>()
    stringVersion.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }

    return map.containsValue(2)
}

fun ascendingOrder(input: Int): Boolean {
    val stringVersion = input.toString()
    stringVersion.take(5).forEachIndexed { index, char ->
        if (char.toInt() > stringVersion.get(index + 1).toInt())
            return false
    }
    return true
}


fun getInput(): String {
    return FileReader(".\\src\\AdventCode2019\\Day_4\\input.txt").readText()
}