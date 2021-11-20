fun main() {
    val count = readLine()!!.toInt()
    var max = Integer.MIN_VALUE
    var min = Integer.MAX_VALUE
    for(i in 1..count) {
        val n = readLine()!!.toInt()
        if(n > max) {
            max = n
        }
        if(n < min) {
            min = n
        }
    }
    println("最小値 = $min, 最大値 = $max")
}