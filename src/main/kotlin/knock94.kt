fun main() {
    val target = (0..9999).random().toString().padStart(4, '0')

    print("4桁の数字を入力: ")
    val input = readLine()!!

    if(input.length != 4) {
        return
    }

    println("target: $target")

    val targetNumbers = target.toCharArray()
    val inputNumbers = input.toCharArray()

    val hit = targetNumbers.zip(inputNumbers).count { it.first == it.second }
    println("$hit hit")
}