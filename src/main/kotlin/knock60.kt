import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JFrame

class DrawCircle(private val positionX: Int, private val positionY: Int): JFrame() {
    init {
        title = "Drawing circle"
        setSize(600, 400)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
    }

    override fun paint(g: Graphics) {
        val g2d = g as Graphics2D
        g2d.drawOval(positionX, positionY, 50, 50)
    }
}

fun main() {
    print("円の中心座標を入力: ")
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    val x = numbers[0]
    val y = numbers[1]
    DrawCircle(x, y)
}