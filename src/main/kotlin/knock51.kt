fun main() {
    print("input money: ")
    var yen = readLine()!!.toInt()
    val oneHundredYenCount = yen / 100
    yen %= 100

    val tenYenCount = yen / 10
    val oneYenCount = yen % 10

    println("100円玉${oneHundredYenCount}枚, 10円玉${tenYenCount}枚, 1円玉${oneYenCount}枚")
}