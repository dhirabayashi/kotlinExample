fun main() {
    print("input number: ")
    val n = readLine()!!.toInt()

    if(n > 0) {
        println("positive")
    } else if(n < 0) {
        println("negative")
    } else {
        println("zero")
    }
}