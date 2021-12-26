enum class Hand(private val value: Int, val displayName: String) {
    GU(0, "グー"),
    CHOKI(1, "チョキ"),
    PA(2, "パー"),
    INVALID(9, "無効");

    fun game(other: Hand): GameResult {
        if(this == INVALID) {
            return GameResult.UNDEFEATED
        }

        return when (other) {
            this -> {
                GameResult.DRAW
            }
            Companion.valueOf((this.value + 1) % 3 ) -> {
                GameResult.WIN
            }
            else -> {
                GameResult.LOSE
            }
        }
    }

    companion object {
        fun valueOf(value: Int): Hand {
            return when(value) {
                0 -> {
                    GU
                }
                1 -> {
                    CHOKI
                }
                2 -> {
                    PA
                }
                else -> {
                    INVALID
                }
            }
        }
    }
}

enum class GameResult {
    WIN,
    DRAW,
    LOSE,
    UNDEFEATED
}

abstract class Player {
    protected var hand: Hand = Hand.INVALID

    private var winCount = 0

    abstract fun determineHand()

    fun game(rival: Player): GameResult {
        val gameResult = hand.game(rival.hand)
        if(gameResult == GameResult.WIN) {
            winCount++
        } else if(gameResult != GameResult.DRAW) {
            rival.winCount++
        }
        return gameResult
    }

    fun hand(): Hand {
        return hand
    }

    fun winCount(): Int {
        return winCount
    }
}

class HumanPlayer: Player() {
    override fun determineHand() {
        print("あなたの手を選んでください(グー0、チョキ1、パー2): ")
        val input = readLine()!!.toInt()
        this.hand =  Hand.valueOf(input)
    }
}

class ComputerPlayer: Player() {
    override fun determineHand() {
        this.hand = Hand.valueOf((0..2).random())
    }
}

fun main() {
    val me = HumanPlayer()
    val rival = ComputerPlayer()

    repeat(5) {
        do {
            me.determineHand()
            rival.determineHand()
            println("あなたは${me.hand().displayName}")
            println("わたしは${rival.hand().displayName}")

            val gameResult = me.game(rival)
            when(gameResult) {
                GameResult.WIN -> {
                    println("あなたの勝ち")
                }
                GameResult.LOSE -> {
                    println("わたしの勝ち")
                }
                GameResult.DRAW -> {
                    println("あいこ")
                }
                GameResult.UNDEFEATED -> {
                    println("そんな手はありません。あなたの負け")
                }
            }
        } while (gameResult == GameResult.DRAW)
        println("あなた${me.winCount()}勝、わたし${rival.winCount()}勝")
    }

    if(me.winCount() > rival.winCount()) {
        println("あなたの総合勝利です。参りました。")
    } else {
        println("わたしの総合勝利です。まだまだですね。")
    }
}