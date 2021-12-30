fun main() {
    val allCards = Suit.values().flatMap { suit ->
        (1..13).map { num ->
            Card(suit, num)
        }
    }.toMutableList()

    allCards.shuffle()

    val cards = mutableListOf<Card>()
    repeat(2) {
        cards.add(allCards.removeAt(0))
    }

    report(cards)

    var sum = sum(cards)
    while(sum < 17) {
        println("もう一枚引きます")
        cards.add(allCards.removeAt(0))
        sum = sum(cards)

        report(cards)
    }

    if(sum > 21) {
        println("バストです")
    } else {
        println("これでOKです")
    }
}

private fun report(cards: List<Card>) {
    cards.forEach {
        print("${it.displayNumber()} ")
    }
    println(": 合計${sum(cards)}")
}

private fun sum(cards: List<Card>): Int {
    var sum = cards.sumOf { it.numberForBlackJack() }
    if(sum <= 21 || !containsAce(cards)) {
        return sum
    }

    val numbers = cards.map { it.numberForBlackJack() }.toMutableList()
    numbers.indices.forEach { i ->
        if(numbers[i] == 11) {
            numbers[i] = 1
            sum = numbers.sum()
            if(sum <= 21) {
                return sum
            }
        }
    }
    return sum
}

private fun containsAce(cards: List<Card>): Boolean {
    return cards.map { it.displayNumber() }.contains("A")
}