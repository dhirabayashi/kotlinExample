fun main() {
    val cards = Suit.values().flatMap { suit ->
        (1..13).map { num ->
            Card(suit, num)
        }
    }.toMutableList()

    cards.shuffle()

    val fst = cards[0]
    val snd = cards[1]
    println("${fst.displayNumber()} ${snd.displayNumber()} : 合計${fst.numberForBlackJack() + snd.numberForBlackJack()}")
}