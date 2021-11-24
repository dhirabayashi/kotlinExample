fun main() {
    val rowCount = 3
    val columnCount = 3
    val matrixCount = 2

    val matrices = mutableListOf<List<List<Int>>>()

    repeat(matrixCount) { i ->
        println("${i + 1}つ目の行列")
        val matrix = mutableListOf<List<Int>>()

        repeat(rowCount) {
            val numbers = readLine()!!.split(" ").map { it.toInt() }
            if(numbers.size != columnCount) {
                System.err.println("数値の入力数が異なります。期待: $columnCount 実際: ${numbers.size}")
                return
            }

            matrix.add(numbers)
        }

        matrices.add(matrix)
    }

    val resultMatrix = mutableListOf<MutableList<Int>>()

    repeat(rowCount) {
        val columns = mutableListOf<Int>()
        repeat(columnCount) {
            columns.add(0)
        }
        resultMatrix.add(columns)
    }

    matrices.forEach { matrix ->
        repeat(rowCount) { i ->
            repeat(columnCount) { j ->
                resultMatrix[i][j] += matrix[i][j]
            }
        }
    }

    println("和")
    resultMatrix.forEach { columns ->
        columns.forEach { num ->
            print(num)
            print("\t")
        }
        println()
    }
}
