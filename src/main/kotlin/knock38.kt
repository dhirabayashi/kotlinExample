fun main() {
    val array = arrayOf(3, 7, 0, 8, 4, 1, 9, 6, 5, 2)
    var index = 0
    for(i in 1..10) {
        println(array[index])
        index = array[index]
    }
}