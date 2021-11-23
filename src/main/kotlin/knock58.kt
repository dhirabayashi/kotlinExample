fun main() {
    val array = IntArray(5)
    for(i in array.indices) {
        print("input data[$i]: ")
        val n = readLine()!!.toInt()
        array[i] = n
    }

    for(n in array) {
        print("$n\t:")
        for(i in 1..n) {
            print("*")
            if(i % 5 == 0) {
                print(" ")
            }
        }
        println()
    }
}