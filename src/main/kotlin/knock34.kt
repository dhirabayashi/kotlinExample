fun main() {
    print("input number: ")
    val n = readLine()!!.toInt()

    for(i in 1..9) {
        if(i == n || i == n + 1) {
            continue
        }
        println(i)
    }
}