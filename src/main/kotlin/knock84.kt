enum class Suit(private val displayName: String) {
    HEARTS("ハート"),
    DIAMONDS("ダイヤ"),
    CLUBS("クラブ"),
    SPADES("スペード");

    fun displayName(): String {
        return displayName
    }
}

data class Card(
    val suit: Suit,
    val number: Int
) {
    companion object {
        val displayStringMap = mapOf(1 to "A", 11 to "J", 12 to "Q", 13 to "K")
    }

    fun displayNumber(): String {
        return displayStringMap[number] ?: number.toString()
    }

    fun numberForBlackJack(): Int {
        return if(number == 1) {
            11
        } else if(number > 10) {
            10
        } else {
            number
        }
    }

    override fun toString(): String {
        return "${suit.displayName()}${displayNumber()}"
    }
}

fun main() {
    val cards = Suit.values().flatMap { suit ->
        (1..13).map { num ->
            Card(suit, num)
        }
    }

    cards.shuffled().forEach {
        println(it)
    }
}