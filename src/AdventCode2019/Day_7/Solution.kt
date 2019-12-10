package AdventCode2019.Day_7

import java.io.FileReader

fun main() {
    val input = getInput()

    val inputInstruction = 0
    val outputInstruction = runProgram(inputInstruction, input.toMutableList())

}

fun runProgram(input: Int, instructions: MutableList<Int>): Int {
    var toReturn = ""

    var mover = 0

    while (mover < instructions.size-1) {
        val opCode = instructions.get(mover)
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
                mover += 4
            }
            2 -> {
                val p1 = instructions[mover+1]
                val p2 = instructions[mover+2]
                val p3 = instructions[mover+3]

                val value1 = if (instructionMode1 == 1) p1 else instructions[p1]
                val value2 = if (instructionMode2 == 1) p2 else instructions[p2]

                instructions[p3] = value1 * value2
                mover += 4
            }
            3 -> {
                val p1 = instructions[mover+1]

                instructions[p1] = input
                mover += 2
            }
            4 -> {
                val p1 = instructions[mover+1]
                val param1 = instructions[p1]

                toReturn += param1
                mover += 2
            }
            5 -> {
                val p1 = instructions[mover+1]
                val p2 = instructions[mover+2]

                val param1 = if (instructionMode1 == 1) p1 else instructions[p1]
                val param2 = if (instructionMode2 == 1) p2 else instructions[p2]

//                if (param1 != 0)
//                    return param2
                mover += 3
            }
            6 -> {
                val p1 = instructions[mover+1]
                val p2 = instructions[mover+2]

                val param1 = if (instructionMode1 == 1) p1 else instructions[p1]
                val param2 = if (instructionMode2 == 1) p2 else instructions[p2]
//                if (param1 == 0)
//                    return param2
                mover += 3
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

                mover += 4
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

                mover += 4
            }
            else -> {
                mover = instructions.size
            }
        }
    }

    return toReturn.toInt()
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

fun getInput(): List<Int> {
    return FileReader(".\\src\\AdventCode2019\\Day_7\\input.txt").readLines().map { it.toInt() }
}