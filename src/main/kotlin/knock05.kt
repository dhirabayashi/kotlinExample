fun main() {
    print("input 1st number: ")
    val x = readLine()!!.toInt()

    print("input 2nd number: ")
    val y = readLine()!!.toInt()

    println("和: ${x + y}")
    println("差: ${x - y}")
    println("積: ${x * y}")
    println("商: ${x / y}, 余り: ${x % y}")
}