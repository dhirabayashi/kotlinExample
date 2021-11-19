fun main() {
    print("input number: ")
    var num = readLine()!!.toInt()

    if(num < 2) {
        return
    }

    var count = 1
    while(num != 1) {
        if(num % 2 == 0) {
            num /= 2
        } else {
            num = num * 3 +1
        }

        println("$count: $num")
        count++
    }
}