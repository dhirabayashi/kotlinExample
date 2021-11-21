fun main() {
    print("input number: ")
    val n = readLine()!!.toInt()
    if(n < 0 || n > 65535) {
        return
    }

    val result = mutableListOf<Int>()

    var quotient = n
    while(quotient != 0) {
        result.add(quotient % 2)
        quotient /= 2
    }
    while(result.size < 16) {
        result.add(0)
    }

    result.reverse()
    result.forEach { print(it) }
    println()
}