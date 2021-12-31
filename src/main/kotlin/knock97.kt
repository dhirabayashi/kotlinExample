fun main() {
    val numbers = (1..75).shuffled().take(25)

    val table = mutableListOf<MutableList<Int>>()
    repeat(5) { i ->
        val columns = mutableListOf<Int>()
        repeat(5) { j ->
            columns.add(numbers[i * 5 + j])
        }
        table.add(columns)
    }

    table.forEach { columns ->
        println(columns.joinToString("\t"))
    }
}