fun main() {
    val array = arrayOf(3, 7, 0, 8, 4, 1, 9, 6, 5, 2)

    for(i in 0..8) {
        println(array[i] - array[i + 1])
    }
}