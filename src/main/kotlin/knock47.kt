fun main() {
    print("input a: ")
    var a = readLine()!!.toInt()

    print("input b: ")
    var b = readLine()!!.toInt()

    val tmp = a;
    a = b;
    b = tmp

    println("a = $a, b = $b")
}