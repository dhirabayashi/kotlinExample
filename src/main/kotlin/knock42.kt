fun main() {
    val list = mutableListOf<Int>()
    for(i in 1..3) {
        print("input number $i: ")
        val n = readLine()!!.toInt()
        list.add(n)
    }
    if(list == list.sorted()) {
        println("OK")
    } else {
        println("NG")
    }
}