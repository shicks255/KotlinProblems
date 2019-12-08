package AdventCode2019.Day_5

import java.io.FileReader

fun main() {

    val instructions = getInput()

    runProgram(instructions)
}

fun runProgram(instructions: MutableList<Int>) {

    var mover = 0
    while (mover < instructions.size) {
        mover = calculate(mover, instructions)
    }
}

fun calculate(mover: Int, instructions: MutableList<Int>): Int {

    val opCode = instructions[mover]
    val paddedOpCode = padOpCode(opCode)

    val operation = paddedOpCode.drop(3).toInt()
    val instructionMode1 = paddedOpCode.get(2).toString().toInt()
    val instructionMode2 = paddedOpCode.get(1).toString().toInt()

    when (operation) {
        1 -> {
            val p1 = instructions[mover+1]
            val p2 = instructions[mover+2]
            val p3 = instructions[mover+3]

            val value1 = if (instructionMode1 == 1) p1 else instructions[p1]
            val value2 = if (instructionMode2 == 1) p2 else instructions[p2]

            instructions[p3] = value1 + value2
            return mover + 4
        }
        2 -> {
            val p1 = instructions[mover+1]
            val p2 = instructions[mover+2]
            val p3 = instructions[mover+3]

            val value1 = if (instructionMode1 == 1) p1 else instructions[p1]
            val value2 = if (instructionMode2 == 1) p2 else instructions[p2]

            instructions[p3] = value1 * value2
            return mover + 4
        }
        3 -> {
            val p1 = instructions[mover+1]

            instructions[p1] = 5
            return mover + 2
        }
        4 -> {
            val p1 = instructions[mover+1]

            val param1 = instructions[p1]

            println(param1)
            return mover +2
        }
        5 -> {
            val p1 = instructions[mover+1]
            val p2 = instructions[mover+2]

            val param1 = if (instructionMode1 == 1) p1 else instructions[p1]
            val param2 = if (instructionMode2 == 1) p2 else instructions[p2]

            if (param1 != 0)
                return param2
            return mover + 3
        }
        6 -> {
            val p1 = instructions[mover+1]
            val p2 = instructions[mover+2]

            val param1 = if (instructionMode1 == 1) p1 else instructions[p1]
            val param2 = if (instructionMode2 == 1) p2 else instructions[p2]
            if (param1 == 0)
                return param2
            return mover + 3
        }
        7 -> {
            val p1 = instructions[mover+1]
            val p2 = instructions[mover+2]
            val p3 = instructions[mover+3]

            val param1 = if (instructionMode1 == 1) p1 else instructions[p1]
            val param2 = if (instructionMode2 == 1) p2 else instructions[p2]

            if (param1 < param2)
                instructions[p3] = 1
            else
                instructions[p3] = 0

            return mover + 4
        }
        8 -> {
            val p1 = instructions[mover+1]
            val p2 = instructions[mover+2]
            val p3 = instructions[mover+3]

            val param1 = if (instructionMode1 == 1) p1 else instructions[p1]
            val param2 = if (instructionMode2 == 1) p2 else instructions[p2]

            if (param1 == param2)
                instructions[p3] = 1
            else
                instructions[p3] = 0

            return mover + 4
        }
        else -> {
            return instructions.size
        }
    }

    return mover
}

fun padOpCode(opCode: Int): String {
    return when {
        opCode < 10 -> "0000" + opCode
        opCode < 100 -> "000" + opCode
        opCode < 1000 -> "00" + opCode
        opCode < 10_000 -> "0" + opCode
        else -> "" + opCode
    }
}

fun getInput(): MutableList<Int> {
    return FileReader(".\\src\\AdventCode2019\\Day_5\\input.txt")
        .readText()
        .split(",")
        .map(String::toInt)
        .toMutableList()
}