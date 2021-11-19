fun main() {
    val array = IntArray(5)

    for(i in 1..array.size) {
        print("input number: ")
        val n = readLine()!!.toInt()
        array[i - 1] = n
    }

    for(n in array) {
        println(n)
    }
}