package knock86

import java.util.*

fun main() {
    print("石の数を入力してください（10以上）: ")
    var stoneCount = readLine()!!.toInt()

    if(stoneCount < 10) {
        return
    }

    val players = mutableListOf(ComputerPlayer(), HumanPlayer())

    report(stoneCount)

    if(stoneCount % 4 == 1) {
        println("あなたからどうぞ")
        Collections.rotate(players, 1)
    } else {
        println("ではわたしから")
    }

    while(true) {
        val takeCount = players.first().determineCount(stoneCount)
        stoneCount -= takeCount

        report(stoneCount)

        if(stoneCount == 1) {
            println("${players.first().displayName()}の勝ち")
            break
        }

        Collections.rotate(players, 1)
    }
}

fun report(stoneCount: Int) {
    println("石の数: $stoneCount")
}