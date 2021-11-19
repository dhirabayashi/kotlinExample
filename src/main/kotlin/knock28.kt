fun main() {
    print("input number: ")
    val n = readLine()!!.toInt()

    //var fact = 1
    //for(i in 1..n) {
    //    fact *= i
    //}

    val fact = fact(n)
    println("factorial = $fact")
}

fun fact(n: Int): Int {
    if(n == 0) {
        return 1
    }

    return fact(n - 1) * n
}