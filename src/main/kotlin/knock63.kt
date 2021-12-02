import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JFrame

class Orthant(private val initX: Int, private val initY: Int): JFrame() {
    private val windowWidth = 600
    private val windowHeight = 400
    private val radius = 50

    init {
        title = "Orthant"
        setSize(windowWidth, windowHeight)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
    }

    override fun paint(g: Graphics) {
        val g2d = g as Graphics2D

        // 区切り線
        val centerHeight = windowHeight / 2
        val centerWidth = windowWidth / 2

        g2d.drawLine(0, centerHeight, windowWidth, centerHeight)
        g2d.drawLine(centerWidth, windowHeight, centerWidth, 0)

        // 円の描画
        val size = radius * 2

        g2d.drawOval(initX - radius, initY - radius, size, size)

        // 円の色塗り
        if(initY >= centerHeight && initX <= centerWidth) {
            //　左下
            g2d.color = Color.RED
        } else if(initY >= centerHeight && initX >= centerWidth) {
            // 右下
            g2d.color = Color.BLUE
        } else if(initY <= centerHeight && initX <= centerWidth) {
            // 左上
            g2d.color = Color.GREEN
        } else if(initY <= centerHeight && initX >= centerWidth) {
            // 右上
            g2d.color = Color.YELLOW
        }

        g2d.fillOval(initX - radius, initY - radius, size, size)
    }
}

fun main() {
    print("円の中心座標を入力: ")
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    val x = numbers[0]
    val y = numbers[1]
    Orthant(x, y)
}