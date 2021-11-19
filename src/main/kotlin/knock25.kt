fun main() {
    print("input number: ")
    val n = readLine()!!.toInt()

    if(n < -10) {
        println("range 1")
    } else if(-10 <= n && n < 0) {
        println("range 2")
    } else {
        // 0以上
        println("range 3")
    }
}