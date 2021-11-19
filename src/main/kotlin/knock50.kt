fun main() {
    for(i in 1..100) {
        if(i % 15 == 0) {
            println("foobar")
        } else if(i % 3 == 0) {
            println("foo")
        } else if(i % 5 == 0) {
            println("bar")
        } else {
            println(i)
        }
    }
}