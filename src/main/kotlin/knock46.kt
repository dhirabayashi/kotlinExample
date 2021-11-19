fun main() {
    print("人数 ")
    val n = readLine()!!.toInt()
    val unit = if(n in 5..19) {
        550
    } else if(n >= 20) {
        500
    } else {
        600
    }

    println("料金 ${unit * n}")
}