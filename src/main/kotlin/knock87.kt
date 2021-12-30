fun main() {
    print("誕生日をYYYYMMDDの形式で入力してください: ")
    val input = readLine()!!
    if(input.length != 8) {
        return
    }

    var number = input.toInt()
    do {
        number = sumDigits(number)
    } while (!isSameNumbers(number) && number > 10)

    println("運命数は$number")
}

private fun sumDigits(num: Int): Int {
    return num.toString().toCharArray().sumOf { it.toString().toInt()}
}

private fun isSameNumbers(num: Int): Boolean {
    return num.toString().toCharArray().distinct().size == 1
}