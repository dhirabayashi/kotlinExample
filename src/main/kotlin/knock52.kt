fun main() {
    print("input year: ")
    val year = readLine()!!.toInt()
    if(year % 400 == 0 || ((year % 4 ==0) && (year % 100 != 0))) {
        println("${year}は閏年である")
    } else {
        println("${year}は閏年でない")
    }
}