package AdventCode2019.Day_3

import java.io.FileReader

data class Point(val x: Int, val y: Int, val steps: Int) {
    override fun equals(other: Any?): Boolean {
        if (other is Point)
            return other.x == this.x && other.y == this.y
        return false
    }
}

fun main() {

    val wires = getInput()
//    val wires = Pair(listOf("R8","U5","L5","D3"), listOf("U7","R6","D4","L4"))

    val grid1: MutableList<Point> = mutableListOf(Point(0,0,0))
    drawWire(wires.first, grid1)

    val grid2: MutableList<Point> = mutableListOf(Point(0,0,0))
    drawWire(wires.second, grid2)

    getIntersection(grid1, grid2)
    println("test")
}

fun getIntersection(grid2: MutableList<Point>, grid1: MutableList<Point>) {

    val sort1 = grid1.sortedWith(compareBy({Math.abs(it.x) + Math.abs(it.y)}))
    val sort2 = grid2.sortedWith(compareBy({Math.abs(it.x) + Math.abs(it.y)}))

    val new1 = sort1.filter { sort2.contains(it) }
    val new2 = sort2.filter { sort1.contains(it) }

    println("hi")
}

fun drawWire(wire: List<String>, grid: MutableList<Point>) {
    wire.forEach{ coord ->
        val direction = coord.first()
        val moves = coord.drop(1).toInt()
        when (direction) {
            'L' -> markGrid(grid, moves, 'L')
            'R' -> markGrid(grid, moves, 'R')
            'U' -> markGrid(grid, moves, 'U')
            'D' ->markGrid(grid, moves, 'D')
        }
    }
}

fun markGrid(grid: MutableList<Point>, moves: Int, direction: Char) {
    for (x in 1..moves) {
        when (direction) {
            'L','R' -> {
                val prev: Point = grid.last()
                if (direction == 'L')
                    grid.add(Point(prev.x-1, prev.y, prev.steps+1))
                else if (direction == 'R')
                    grid.add(Point(prev.x+1, prev.y, prev.steps+1))
            }
            'U','D' -> {
                val prev: Point = grid.last()
                if (direction == 'U')
                    grid.add(Point(prev.x, prev.y+1, prev.steps+1))
                if (direction == 'D')
                    grid.add(Point(prev.x, prev.y-1, prev.steps+1))
            }
        }
    }
}

fun getInput(): Pair<List<String>, List<String>> {

    val file = FileReader(".\\src\\AdventCode2019\\Day_3\\input.txt")

    val both = file.readText().split("\n")

    val pair: Pair<List<String>, List<String>> = Pair(
        both.get(0).replace("\r", "").split(","),
        both.get(1).replace("\r", "").split(",")
    )

    return pair
}