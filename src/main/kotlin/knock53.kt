fun main() {
    print("input number: ")
    var num = readLine()!!.toInt()

    if(num < 2) {
        return
    }

    var divisor = 2

    while(num != 1) {
        if(num % divisor == 0) {
            print("$divisor ")
            num /= divisor
        } else {
            divisor++
        }
    }
}