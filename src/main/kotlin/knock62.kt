import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JFrame

class PortableSquareAndCircle(private val initX: Int, private val initY: Int): JFrame() {
    private val radius = 80

    init {
        title = "Drawing square and circle"
        setSize(600, 400)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
    }

    override fun paint(g: Graphics) {
        val g2d = g as Graphics2D

        // 円の描画
        g2d.drawOval(initX - radius, initY - radius, radius * 2, radius * 2)

        // 正方形の描画
        val point = Point(initX - radius, initY + radius)
        point.drawLineRightAndMove(g2d, radius * 2)
        point.drawLineDownAndMove(g2d, radius * 2)
        point.drawLineLeftAndMove(g2d, radius * 2)
        point.drawLineUpAndMove(g2d, radius * 2)
    }
}

fun main() {
    print("円の中心座標を入力: ")
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    val x = numbers[0]
    val y = numbers[1]
    PortableSquareAndCircle(x, y)
}