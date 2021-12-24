import java.awt.Color
import java.awt.Graphics
import java.lang.Thread.sleep
import javax.swing.JFrame
import kotlin.math.sqrt

class MonteCarlo: JFrame() {
    private val windowWidth = 400
    private val windowHeight = 400
    private val radius = 1
    private val size = radius * 2

    val numOfPoint = 10000
    var redCount = 0

    init {
        title = "Monte-Carlo"
        setSize(windowWidth, windowHeight)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
    }

    override fun paint(g: Graphics) {
        val range = (0..399)
        repeat(numOfPoint) {
            val circleX = range.random()
            val circleY = range.random()

            g.color = if(distance(circleX, circleY) <= 400) {
                redCount++
                Color.RED
            } else {
                Color.BLUE
            }

            g.drawOval(circleX - radius, circleY - radius, size, size)
        }
    }
}

private fun distance(x: Int, y: Int): Double {
    return sqrt((x * x + y * y).toDouble())
}

fun main() {
    val calculator = MonteCarlo()
    sleep(1000)

    val redCount = calculator.redCount
    val numOfPoint = calculator.numOfPoint
    val pi = (redCount * 4.0) / numOfPoint
    println("pi = $pi")
}