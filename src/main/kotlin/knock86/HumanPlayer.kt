package knock86

class HumanPlayer: Player {
    override fun determineCount(currentNum: Int): Int {
        var takeCount: Int
        do {
            print("何個取る（1〜3個）? ")
            takeCount = readLine()!!.toInt()
        } while (takeCount < 1 || takeCount > 3)
        return takeCount
    }

    override fun displayName(): String {
        return "あなた"
    }
}