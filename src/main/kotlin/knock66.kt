import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JFrame

class CircleX(private val initX: Int, private val initY: Int): JFrame() {
    private val windowWidth = 600
    private val windowHeight = 400
    private val radius = 10

    init {
        title = "Circle Cross"
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

        // \の描画
        var circleX = initX - interval * (numOfCircle - 1) / 2
        var circleY = initY - interval * (numOfCircle - 1) / 2
        repeat(numOfCircle) {
            g2d.drawOval(circleX - radius, circleY - radius, size, size)
            circleX += interval
            circleY += interval
        }

        // /の描画
        circleX = initX + interval * (numOfCircle - 1) / 2
        circleY = initY - interval * (numOfCircle - 1) / 2
        repeat(numOfCircle) {
            g2d.drawOval(circleX - radius, circleY - radius, size, size)
            circleX -= interval
            circleY += interval
        }
    }
}

fun main() {
    print("円の中心座標を入力: ")
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    val x = numbers[0]
    val y = numbers[1]
    CircleX(x, y)
}