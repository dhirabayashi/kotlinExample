fun main() {
    print("input number: ")
    val n = readLine()!!.toInt()

    if(-5 <= n && n < 10) {
        println("OK")
    } else {
        println("NG")
    }
}