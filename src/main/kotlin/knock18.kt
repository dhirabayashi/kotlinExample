fun main() {
    val array = IntArray(10)
    print("input number: ")
    val input = readLine()!!.toInt()

    for(i in 0..9) {
        array[i] = input
    }

    for(n in array) {
        println(n)
    }
}