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
    override fun toString(): String {
        return "${suit.displayName()}${number}"
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