fun main() {
    val numOfStep = 15
    val steps = mutableListOf<MutableList<Int>>()
    (0 until numOfStep).forEach { i ->
        val numbers = mutableListOf<Int>()
        numbers.add(1)

        (1 until i).forEach { j ->
            numbers.add(steps[i - 1][j - 1] + steps[i - 1][j])
        }
        if(i != 0) {
            numbers.add(1)
        }

        steps.add(numbers)
    }

    steps.forEach { numbers ->
        println(numbers.joinToString(" ") { it.toString() })
    }
}