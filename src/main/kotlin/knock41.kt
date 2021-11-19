fun main() {
    print("input number: ")
    val n = readLine()!!.toInt()

    if(n in 1..9) {
        println("$n is a single figure.")
    } else {
        println("$n is not a single figure.")
    }
}