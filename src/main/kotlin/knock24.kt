fun main() {
    print("input number: ")
    val n = readLine()!!.toInt()

    if((-10 <= n && n < 0) || n >= 10) {
        println("OK")
    } else {
        println("NG")
    }
}