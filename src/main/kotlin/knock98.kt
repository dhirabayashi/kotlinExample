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

    printTable(table)

    val bingoNumbers = (1..75).shuffled().toMutableList()
    var count = 1
    while(bingoNumbers.isNotEmpty()) {
        val targetNumber = bingoNumbers.removeAt(0)
        println("${count}個目: $targetNumber")

        if(punch(table, targetNumber)) {
            println("あった！")
        }
        printTable(table)

        if(isBingo(table)) {
            println("***** BINGO *****")
            break
        }

        count++
    }
}

private fun printTable(table: List<List<Int>>) {
    table.forEach { columns ->
        println(columns.joinToString("\t"))
    }
}

private fun punch(table: MutableList<MutableList<Int>>, targetNumber: Int): Boolean {
    repeat(5) { i ->
        repeat(5) { j ->
            if(table[i][j] == targetNumber) {
                table[i][j] = 0
                return true
            }
        }
    }
    return false
}

private fun isBingo(table: MutableList<MutableList<Int>>): Boolean {
    // 横
    table.forEach { columns ->
        if(columns.distinct() == listOf(0)) {
            return true
        }
    }

    // 縦
    repeat(5) { i ->
        if(table.map { it[i] }.distinct() == listOf(0)) {
            return true
        }
    }

    // 斜め
    if(table.zip(table.indices).map { it.first[it.second] }.distinct() == listOf(0)) {
        return true
    }
    if(table.zip(table.indices.reversed()).map { it.first[it.second] }.distinct() == listOf(0)) {
        return true
    }

    return false
}
