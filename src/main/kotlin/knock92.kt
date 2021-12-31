fun main() {
    (1..50).forEach { n ->
        if(n % 3 == 0 || n.toString().contains("3")) {
            println("aho $n")
        } else {
            println(n)
        }
    }
}