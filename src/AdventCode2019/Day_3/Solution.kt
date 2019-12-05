package AdventCode2019.Day_3

import CodeWars.PrinterErrors.printerErrors
import CodeWars.ShortestWord.findShort
import java.io.FileReader
import java.lang.StringBuilder

fun main() {

//    val wires = getInput()
    val wires = Pair(listOf("R8","U5","L5","D3"), listOf("U7","R6","D4","L4"))

    val grid1: MutableList<Pair<Int, Int>> = mutableListOf(Pair(0,0))
    drawWire(wires.first, grid1)

    val grid2: MutableList<Pair<Int, Int>> = mutableListOf(Pair(0,0))
    drawWire(wires.second, grid2)


    println("test")
}

fun drawWire(wire: List<String>, grid: MutableList<Pair<Int, Int>>) {
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

fun markGrid(grid: MutableList<Pair<Int, Int>>, moves: Int, direction: Char) {
    for (x in 1..moves) {
        when (direction) {
            'L','R' -> {
                val prev: Pair<Int, Int> = grid.last()
                if (direction == 'L')
                    grid.add(prev.copy(prev.first-1, prev.second))
                else if (direction == 'R')
                    grid.add(prev.copy(prev.first+1, prev.second))
            }
            'U','D' -> {
                val prev: Pair<Int, Int> = grid.last()
                if (direction == 'U')
                    grid.add(prev.copy(prev.first, prev.second+1))
                if (direction == 'D')
                    grid.add(prev.copy(prev.first, prev.second-1))
            }
        }
    }
}

fun main2() {
    val wires = getInput()
//    val wires = Pair(listOf("R8","U5","L5","D3"), listOf("U7","R6","D4","L4"))

    val board = MutableList<MutableList<String>>(20_000, { i -> MutableList(20_000, {i -> "."}) })

    board[50][50] = "0"

    drawBoardFromWire(wires.first, board, false)
    drawBoardFromWire(wires.second, board, true)

    println(wires)
    printBoard(board)
}

fun drawBoardFromWire(wire: List<String>, board: MutableList<MutableList<String>>, lastAttempt: Boolean) {
    var start = Pair(5000,5000)

    wire.forEach {move ->
        val coord = move.drop(1).toInt()
        start = draw(coord, move.first(), board, start, lastAttempt)
    }

    board[50][50] = "0"
}

fun markBoard(board: MutableList<MutableList<String>>, first: Int, second: Int, char: String) {

    if (board[first][second] == ".")
        board[first][second] = char
    else if (char == "2" && board[first][second] == "1")
        board[first][second] = "X"
}

fun draw(newCord: Int, direction: Char, board: MutableList<MutableList<String>>, start: Pair<Int, Int>, last: Boolean): Pair<Int, Int> {
    when (direction) {
        'R' -> {
            for (i in 1..newCord)
                markBoard(board, start.first, start.second + i, if (last) "2" else "1")
            return start.copy(start.first, start.second + newCord)
        }
        'L' -> {
            for (i in 1..newCord)
                markBoard(board, start.first, start.second-i, if (last) "2" else "1")
            return start.copy(start.first, start.second - newCord)
        }
        'U' -> {
            for (i in 1..newCord)
                markBoard(board, start.first - i, start.second, if (last) "2" else "1")
            return start.copy(start.first - newCord, start.second)
        }
        'D' -> {
            for (i in 1..newCord)
                markBoard(board, start.first + i, start.second, if (last) "2" else "1")
            return start.copy(start.first + newCord, start.second)
        }
    }

    //this shouldn't happen
    return start
}

fun printBoard(board: MutableList<MutableList<String>>) {

    val string = StringBuilder()

    board.forEach {
        it.forEach {
            string.append(it)
        }
        string.append("\r\n")
    }

    println(string)
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