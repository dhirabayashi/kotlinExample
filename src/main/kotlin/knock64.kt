import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import javax.swing.JFrame

class OrthantAndSquare(private val initX: Int, private val initY: Int): JFrame() {
    private val windowWidth = 600
    private val windowHeight = 400
    private val radius = 50
    private val squareSize = 200

    init {
        title = "Orthant"
        setSize(windowWidth, windowHeight)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
    }

    override fun paint(g: Graphics) {
        val g2d = g as Graphics2D

        // 正方形
        val squareInitX = windowWidth / 2 - squareSize / 2
        val squareInitY = windowHeight / 2 - squareSize / 2

        val point = Point(squareInitX, squareInitY)
        point.drawLineDownAndMove(g2d, squareSize)
        point.drawLineRightAndMove(g2d, squareSize)
        point.drawLineUpAndMove(g2d, squareSize)
        point.drawLineLeftAndMove(g2d, squareSize)

        // 区切り線
        val centerHeight = windowHeight / 2
        val centerWidth = windowWidth / 2

        val horizontalLength = windowWidth - squareInitX - squareSize
        val verticalLength = windowHeight - squareInitY - squareSize

        g2d.drawLine(0, centerHeight, horizontalLength, centerHeight)
        g2d.drawLine(horizontalLength + squareSize, centerHeight, windowWidth, centerHeight)

        g2d.drawLine(centerWidth, 0, centerWidth, windowHeight - verticalLength - squareSize)
        g2d.drawLine(centerWidth, verticalLength + squareSize, centerWidth, windowHeight)

        // 円の描画
        val size = radius * 2

        g2d.drawOval(initX - radius, initY - radius, size, size)

        // 円の色塗り
        val windowCenterX = windowWidth / 2
        val windowCenterY = windowHeight / 2

        if(initX >= (windowCenterX - squareSize / 2) && initX <= (windowCenterX + squareSize / 2)
            && initY >= (windowCenterY - squareSize / 2) && initY <= (windowCenterY + squareSize / 2)) {
            // 真ん中
            g2d.color = Color.ORANGE
        }
        else if(initY >= centerHeight && initX <= centerWidth) {
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
    OrthantAndSquare(x, y)
}