fun main() {
    print("input 1st value: ")
    val x = readLine()!!.toInt()

    print("input 2nd value: ")
    val y = readLine()!!.toInt()

    val z = x / y

    println("result: $z")
    println("result: ${z * y}")
}