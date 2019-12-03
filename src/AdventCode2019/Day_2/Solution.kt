package AdventCode2019.Day_2

import java.io.FileReader

fun main() {

    var answer = 0
    var noun = 0
    var verb = 0

    while (answer != 19690720) {
        answer = runProgram(noun, verb)
        if (answer == 19690720) {
            println("the noun is $noun and the verb is $verb")
            println("the final answer is ${100 * noun + verb}")
        }
        else
            if (verb < 99)
                verb += 1
            else {
                verb = 0
                noun += 1
            }
    }

}

fun runProgram(noun: Int, verb: Int): Int {

    val input = getInputArray().toMutableList()

    input.set(1, noun)
    input[2] = verb

    var mover = 0
    while (mover < input.size-3) {
        mover = calculate(input, mover)
    }

    return input.get(0)
}

fun calculate(array: MutableList<Int>, mover: Int): Int {
    val posOne = array.get(mover)
    val postTwo = array.get(mover+1)
    val posThree = array.get(mover+2)
    val posFour = array.get(mover+3)

    var func: (Int,Int) -> Int
    if (posOne === 1)
        func = {i: Int, b: Int -> i+b}
    else if (posOne === 2)
        func = { i: Int, b: Int -> i*b }
    else
        return array.size

    array.set(posFour, func(array.get(postTwo), array.get(posThree)))

    return mover + 4
}

fun getInputArray(): List<Int> {
    val reader = FileReader(".\\src\\AdventCode2019\\Day_2\\input.txt")
    val line = reader.readText()
    return line.split(",").map(String::toInt)
}