fun main() {
    val target = (0..9999).random().toString().padStart(4, '0')
    val targetNumbers = target.toCharArray()

    var count = 1
    while(true) {
        println("${count}回目")
        print("4桁の数字を入力: ")
        val input = readLine()!!

        if(input.length != 4) {
            continue
        }

        val inputNumbers = input.toCharArray()

        val hit = targetNumbers.zip(inputNumbers).count { it.first == it.second }

        val pair = targetNumbers.zip(inputNumbers).filter { it.first != it.second }.unzip()
        val blow = pair.first.intersect(pair.second.toSet()).size

        if(hit == 4) {
            break
        }

        println("$hit hit, $blow blow")

        count++
    }

    println("正解")
}