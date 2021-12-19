import java.awt.Color
import java.awt.Graphics
import java.util.*
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.SwingUtilities
import javax.swing.Timer

class BoundFiveWithColor: JFrame() {
    private val windowWidth = 600
    private val windowHeight = 400

    init {
        title = "bound five with color"
        setSize(windowWidth, windowHeight)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE

        val mainPanel = contentPane
        mainPanel.add(BoundFiveWithColorComponent(windowWidth, windowHeight))
    }
}

data class BoundCircleWithColor(
    val body: BoundCircle
) {
    private val colors = mutableListOf(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW)

    fun currentColor(): Color {
        return colors[0]
    }

    fun rotateColor() {
        Collections.rotate(colors, -1)
    }
}

class BoundFiveWithColorComponent(private val windowWidth: Int, private val windowHeight: Int): JComponent() {
    private val radius = 30
    private val size = radius * 2
    private val initX = 30
    private val initY = windowHeight - 30

    private val circles = listOf(
        BoundCircleWithColor(BoundCircle(initX, initY, 1, -5)),
        BoundCircleWithColor(BoundCircle(initX, initY, 2, -4)),
        BoundCircleWithColor(BoundCircle(initX, initY, 3, -3)),
        BoundCircleWithColor(BoundCircle(initX, initY, 4, -2)),
        BoundCircleWithColor(BoundCircle(initX, initY, 5, -1)),
    )
    private val delay = 50
    private var timer: Timer = Timer(delay) {
        // 描画の更新
        circles.forEach { circle ->
            circle.body.x += circle.body.incrementalX
            circle.body.y += circle.body.incrementalY

            // 反射判定
            val rightEdge = circle.body.x + radius
            val leftEdge = circle.body.x - radius

            if(rightEdge >= windowWidth || leftEdge <= 0) {
                circle.body.incrementalX = -circle.body.incrementalX
                circle.rotateColor()
            }

            val upperEdge = circle.body.y - radius
            val bottomEdge = circle.body.y + radius

            if(bottomEdge >= windowHeight || upperEdge <= 0) {
                // タイトルバーの分？めり込むけどまあいいや…
                circle.body.incrementalY = -circle.body.incrementalY
                circle.rotateColor()
            }
        }

        repaint()
    }

    init {
        timer.isRepeats = true
        timer.start()
    }

    override fun paintComponent(g: Graphics) {
        // 円の描画
        g.color = Color.RED
        circles.forEach { circle ->
            g.color = circle.currentColor()

            g.drawOval(circle.body.x - radius, circle.body.y - radius, size, size)
            g.fillOval(circle.body.x - radius, circle.body.y - radius, size, size)
        }
    }
}

fun main() {
    SwingUtilities.invokeLater {
        BoundFiveWithColor().isVisible = true
    }
}