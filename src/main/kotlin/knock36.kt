fun main() {
    val array = arrayOf(3, 7, 0, 8, 4, 1, 9, 6, 5, 2)

    print("input number: ")
    val i = readLine()!!.toInt()

    print("input number: ")
    val j = readLine()!!.toInt()

    val n = array[i]
    val m = array[j]
    println("$n * $m = ${n * m}")
}