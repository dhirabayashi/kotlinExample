fun main() {
    print("input number: ")
    val n = readLine()!!.toInt()

    for(i in 1..9) {
        if(i == n) {
            continue
        }
        println(i)
    }
}