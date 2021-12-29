import java.util.*

fun main() {
    print("石の数を入力してください（10以上）: ")
    var stoneCount = readLine()!!.toInt()
    if(stoneCount < 10) {
        return
    }

    val playerNumbers = (1..2).toMutableList()
    while(true) {
        report(stoneCount)

        var takeCount: Int
        do {
            println("プレイヤー${playerNumbers.first()}の番です")
            print("何個取る（1〜3個）? ")
            takeCount = readLine()!!.toInt()

        } while (takeCount < 1 || takeCount > 3)

        stoneCount -= takeCount

        report(stoneCount)

        if(stoneCount <= 1) {
            val lastPlayer = "プレイヤー${playerNumbers.first()}"
            when(stoneCount) {
                0 -> {
                    println("${lastPlayer}の負け")
                }
                1 -> {
                    println("${lastPlayer}の勝ち")
                }
                else -> {
                    println("${lastPlayer}の反則負け")
                }
            }
            break
        }

        Collections.rotate(playerNumbers, 1)
    }
}

private fun report(stoneCount: Int) {
    println("石の数: $stoneCount")
}