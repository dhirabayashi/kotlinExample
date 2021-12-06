import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JFrame

class FiveXFiveCircle(): JFrame() {
    private val windowWidth = 600
    private val windowHeight = 400
    private val radius = 10
    private val initX = windowWidth / 2
    private val initY = windowHeight / 2

    init {
        title = "5 x 5 Circle"
        setSize(windowWidth, windowHeight)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
    }

    override fun paint(g: Graphics) {
        val g2d = g as Graphics2D

        val size = radius * 2
        val numOfCircle = 5
        val interval = 30

        var circleX = initX
        var circleY = initY

        // 円の描画
        repeat(numOfCircle) {
            repeat(numOfCircle) {
                g2d.drawOval(circleX - radius, circleY - radius, size, size)
                circleX += interval
            }
            circleY += interval
            circleX = initX
        }
    }
}

fun main() {
    FiveXFiveCircle()
}