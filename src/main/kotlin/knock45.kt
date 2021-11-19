fun main() {
    print("距離 ")
    val dist = readLine()!!.toInt()

    var charge = 610
    val addition = dist - 1700
    // 初乗り料金を超えた分の計算
    if(addition > 0) {
        var count = addition / 313
        if(addition % 313 != 0) {
            count++
        }
        charge += count * 80
    }
    println("金額 $charge")
}