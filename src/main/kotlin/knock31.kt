fun main() {
    print("input number: ")
    val n = readLine()!!.toInt()

    for(i in 1..n) {
        print("*")
        if(i % 5 == 0) {
            print(" ")
        }
    }
    println()
}