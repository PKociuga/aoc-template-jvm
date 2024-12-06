import java.io.File

fun main() {
    println(part1())
    println(part2())
}

fun part1(): Any {
    return mul(input)
}

fun part2(): Any {
    return mulDisabled(input)
}

fun mul(input: String): Int {
    val regex = Regex("mul\\((\\d+),(\\d+)\\)")
    return regex.findAll(input).sumOf { matchResult ->
        val firstDigit = matchResult.groups[1]!!.value.toInt()
        val secondDigit = matchResult.groups[2]!!.value.toInt()
        firstDigit * secondDigit
    }
}

fun mulDisabled(input: String): Int {
    val pattern = "(mul\\([0-9]+,[0-9]+\\))|(don't\\(\\))|(do\\(\\))".toRegex()
    val numberPattern = "[0-9]+".toRegex()
    var total = 0
    var isEnabled = true
    val matches = pattern.findAll(input)
    for (match in matches) {
        when {
            match.value == "don't()" -> isEnabled = false
            match.value == "do()" -> isEnabled = true
            match.value.startsWith("mul(") -> {
                val numbers = numberPattern.findAll(match.value).map { it.value.toInt() }.toList()
                if (isEnabled && numbers.size == 2) {
                    total += numbers[0] * numbers[1]
                }
            }
        }
    }
    return total
}

private val input: String by lazy {readInput()}

private fun readInput(): String {
    return object {}.javaClass.getResource("Day3.input")?.readText() ?: ""
}
