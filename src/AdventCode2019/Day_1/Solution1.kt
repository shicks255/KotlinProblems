package AdventCode2019.Day_1

import java.io.File
import java.io.FileReader

fun main() {
    val lines = getFileLines()
    val sum = lines.map { getFuelNeeded(it.toInt()) }.sum()
    println(sum)

    val part2 = lines.map { getFuel(it.toInt(), 0) }

    println(part2.sum())
}

fun getFileLines(): List<String> {
    return FileReader(".\\src\\AdventCode2019\\Day_1\\input.txt").readLines()
}

fun getFuel(line: Int, soFar: Int): Int {
    if (line <= 0)
        return soFar
    val needed = getFuelNeeded(line)
    val count = soFar + if (needed > 0) needed else 0
    return getFuel(needed, count)
}

fun getFuelNeeded(line: Int): Int {
    return Math.floorDiv(line, 3) -2
}