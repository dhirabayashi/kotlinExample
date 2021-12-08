import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JFrame
import kotlin.math.roundToInt

class Squares(private val numSquares: Int): JFrame() {
    private val windowWidth = 600
    private val windowHeight = 600

    init {
        title = "Squares"
        setSize(windowWidth, windowHeight)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
    }

    override fun paint(g: Graphics) {
        val g2d = g as Graphics2D

        // 縦の描画
        val intervalX = (windowWidth.toDouble() / numSquares).roundToInt()
        var x = intervalX
        repeat(numSquares - 1) {
            g2d.drawLine(x, 0, x, windowHeight)
            x += intervalX
        }

        // 横の描画
        val intervalY = (windowHeight.toDouble() / numSquares).roundToInt()
        var y = intervalY
        repeat(numSquares - 1) {
            g2d.drawLine(0, y, windowWidth, y)
            y += intervalY
        }
    }
}

fun main() {
    print("マス目の数: ")
    val numSquares = readLine()!!.toInt()

    if(numSquares < 2) {
        return
    }

    Squares(numSquares)
}