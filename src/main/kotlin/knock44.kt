fun main() {
    print("何円? ")
    val yen = readLine()!!.toInt()

    print("1ドルは何円? ")
    val unit = readLine()!!.toInt()

    val dollar = yen / unit
    val cent = ((yen.toDouble() / unit - dollar) * 100).toInt()

    println("${yen}円は${dollar}ドル${cent}セント")
}