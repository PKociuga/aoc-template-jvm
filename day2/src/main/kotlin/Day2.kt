import kotlin.math.abs

fun main() {
    println(part1())
    println(part2())
}

fun part1(): Any {
    val result = input.map { line ->
        line.split(" ").map { item -> item.toInt() }
    }
    return result.count { isSafe(it) }
}

fun part2(): Any {
    val result = input.map { line ->
        line.split(" ").map { item -> item.toInt() }
    }
    return result.count { isSafeDampened(it) }
}

private fun isSafe(list: List<Int>): Boolean {
    var isDescending = true
    var isIncreasing = true

    for(i in 0 until list.size - 1) {
        val diff = abs(list[i] - list[i + 1])
        if(diff < 1 || diff > 3) {
            return false
        }
        if(list[i] < list[i + 1]) {
            isDescending = false
        } else if(list[i] > list[i + 1]) {
            isIncreasing = false
        }
    }
    return isDescending || isIncreasing
}

private fun isSafeDampened(report: List<Int>): Boolean =
    report.indices.any { item ->
        isSafe(report.filterIndexed { index, _ -> item != index })
    }

private val input: List<String> by lazy {readInput()}

private fun readInput(): List<String> {
    return object {}.javaClass.getResourceAsStream("Day2.input")?.bufferedReader()?.readLines() ?: emptyList()
}
