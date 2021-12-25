import kotlin.math.min

fun main() {
    print("2つの値をスペースで区切って入力: ")
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    val x = numbers[0]
    val y = numbers[1]

    (2..(min(x, y))).forEach { num ->
        if(x % num == 0 && y % num == 0) {
            println("互いに素でない")
            return
        }
    }
    println("互いに素")
}