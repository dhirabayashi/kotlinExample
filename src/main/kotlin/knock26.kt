fun main() {
    print("input number: ")

    when(readLine()!!.toInt()) {
        1 -> {
            println("one")
        }
        2 -> {
            println("two")
        }
        3 -> {
            println("three")
        }
        else -> {
            println("other")
        }
    }
}