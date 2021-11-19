fun main() {
    print("input number: ")
    val n = readLine()!!.toInt()

    if(n <= -10 || n >= 10) {
        println("OK")
    }
}