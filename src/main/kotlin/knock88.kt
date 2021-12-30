fun main() {
    val correctNumber = (1..99).random()

    var count = 0
    do {
        count++

        print("数を入力: ")
        val input = readLine()!!.toInt()

        if(input > correctNumber) {
            println("それより小さいです")
        } else if(input < correctNumber) {
            println("それより大きいです")
        } else {
            break
        }
    } while(true)

    println("正解!! ${count}回でクリア")
}