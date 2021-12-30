fun main() {
    var lowerLimit = 1
    var upperLimit = 99
    var count = 1

    do {
        val number = (lowerLimit + upperLimit) / 2

        print("${number}ですか? ")
        val answer = readLine()!!.toInt()

        if(answer < 0) {
            upperLimit = number - 1
        } else if(answer > 0) {
            lowerLimit = number + 1
        } else {
            break
        }

        count++
    } while(true)

    println("${count}回で当てました")
}