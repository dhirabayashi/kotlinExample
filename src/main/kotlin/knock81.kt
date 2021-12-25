fun main() {
    print("3つの値を入力: ")
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    println(numbers.sorted()[1])
}