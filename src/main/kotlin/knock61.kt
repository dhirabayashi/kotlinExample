import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JFrame

class SquareAndCircle: JFrame() {
    private val size = 200
    private val initX = 200
    private val initY = 100

    init {
        title = "Drawing square and circle"
        setSize(600, 400)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
    }

    override fun paint(g: Graphics) {
        val g2d = g as Graphics2D

        // 正方形の描画
        val point = Point(initX, initY)
        point.drawLineDownAndMove(g2d, size)
        point.drawLineRightAndMove(g2d, size)
        point.drawLineUpAndMove(g2d, size)
        point.drawLineLeftAndMove(g2d, size)

        // 円の描画
        g2d.drawOval(initX, initY, size, size)
    }
}

data class Point(private var x: Int, private var y: Int) {
    fun drawLineDownAndMove(g: Graphics, size: Int) {
        val newY = y + size
        g.drawLine(x, y, x, newY)
        y = newY
    }

    fun drawLineUpAndMove(g: Graphics, size: Int) {
        val newY = y - size
        g.drawLine(x, y, x, newY)
        y = newY
    }

    fun drawLineRightAndMove(g: Graphics, size: Int) {
        val newX = x + size
        g.drawLine(x, y, newX, y)
        x = newX
    }

    fun drawLineLeftAndMove(g: Graphics, size: Int) {
        val newX = x - size
        g.drawLine(x, y, newX, y)
        x = newX
    }
}

fun main() {
    SquareAndCircle()
}