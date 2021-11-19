fun main() {
    print("input a: ")
    val a = readLine()!!.toInt()

    print("input b: ")
    val b = readLine()!!.toInt()

    print("input c: ")
    val c = readLine()!!.toInt()

    val d = b * b - 4 * a * c

    if(d > 0) {
        println("2つの実数解")
    } else if(d < 0) {
        println("2つの虚数解")
    } else {
        // d == 0
        println("重解")
    }
}