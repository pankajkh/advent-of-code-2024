import kotlin.math.abs
import kotlin.math.min

fun main() {
    fun part1(firstList: MutableList<Int>, secondList: MutableList<Int>): Int {
        firstList.sort()
        secondList.sort()

        var totalDistance =  0
        firstList.forEachIndexed { index, value   ->
            totalDistance += abs(value - secondList[index])
        }

        return totalDistance
    }

    fun part2(leftMap: MutableMap<Int, Int>, rightMap: MutableMap<Int, Int>): Int {
        var similarityScore = 0
        leftMap.forEach { k, v ->
            similarityScore += k*v*(rightMap[k] ?: 0)
        }

        return similarityScore
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
//    val input = readInput("Day01_test")
    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")

    val firstList = mutableListOf<Int>()
    val secondList = mutableListOf<Int>()

    val leftMap = mutableMapOf<Int, Int>()
    val rightMap = mutableMapOf<Int, Int>()
    input.forEach {
        it.split(" ").let {
            val localFirst = Integer.valueOf(it.first())
            val localSecond = Integer.valueOf(it.last())
            firstList.add(localFirst)
            secondList.add(localSecond)

            leftMap[localFirst] = (leftMap[localFirst]  ?: 0) + 1
            rightMap[localSecond]  = (rightMap[localSecond] ?: 0) + 1
        }
    }

    println(part1(firstList, secondList))
    println(part2(leftMap, rightMap))
}
