fun main() {
    print("start: ")
    val start = readLine()!!.toInt()

    print("end: ")
    val end = readLine()!!.toInt()

    (start..end).forEach { n ->
        if(isAho(n)) {
            println("aho $n")
        } else {
            println(n)
        }
    }
}

private fun isAho(n: Int): Boolean {
    if(n % 3 == 0) {
        return true
    }

    val divisor = 10
    var number = n
    while(number != 0) {
        if(number % divisor == 3) {
            return true
        }
        number /= divisor
    }
    return false
}