package knock86

class ComputerPlayer: Player {
    override fun determineCount(currentNum: Int): Int {
        // 残り個数が4の倍数 + 1になるようにする
        var targetNum = currentNum
        while(targetNum % 4 != 1) {
            targetNum--
        }
        val takeCount = currentNum - targetNum
        println("${takeCount}個取ります")
        return takeCount
    }

    override fun displayName(): String {
        return "わたし"
    }
}