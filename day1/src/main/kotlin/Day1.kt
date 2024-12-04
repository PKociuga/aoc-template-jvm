import kotlin.math.abs

const val SPACE = "   "

fun main() {
    println(part1())
    println(part2())
}

fun part1(): Any {
    val (first, second) = input.map { line ->
        line.substringBefore(SPACE).toInt() to line.substringAfter(SPACE).toInt()
    }.unzip()
    return first.sorted().zip(second.sorted()).sumOf { (item1, item2) -> abs(item1 - item2) }
}

fun part2(): Any {
    val (first, second) = input.map { line ->
        line.substringBefore(SPACE).toInt() to line.substringAfter(SPACE).toInt()
    }.unzip()
    return first.sumOf { number -> second.count { it == number } * number }
}

private val input: List<String> by lazy {readInput()}

private fun readInput(): List<String> {
    return object {}.javaClass.getResourceAsStream("Day1.input")?.bufferedReader()?.readLines() ?: emptyList()
}
