fun main() {
    val count = readLine()!!.toInt()
    val examinees = mutableListOf<Examinee>()
    var englishScoreSum = 0
    var mathScoreSum = 0
    var japaneseScoreSum = 0
    for(i in 1..count) {
        val scores = readLine()!!.split(" ")
        val englishScore = scores[0].toInt()
        val mathScore = scores[1].toInt()
        val japaneseScore = scores[2].toInt()

        englishScoreSum += englishScore
        mathScoreSum += mathScore
        japaneseScoreSum += japaneseScore

        examinees.add(Examinee(englishScore, mathScore, japaneseScore))
    }

    println("平均点 英語:${englishScoreSum / count}, 数学:${mathScoreSum / count}, 国語:${japaneseScoreSum / count}")

    for((index, examinee) in examinees.withIndex()) {
        println("$index: ${examinee.total()}")
    }
}

data class Examinee(val englishScore: Int, val mathScore: Int, val japaneseScore: Int) {
    fun total(): Int {
        return englishScore + mathScore + japaneseScore
    }
}