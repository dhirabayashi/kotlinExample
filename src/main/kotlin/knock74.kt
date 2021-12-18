import java.awt.Color
import java.awt.Graphics
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.SwingUtilities
import javax.swing.Timer

class BoundDoubleWithColor: JFrame() {
    private val windowWidth = 600
    private val windowHeight = 400

    init {
        title = "bound double"
        setSize(windowWidth, windowHeight)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE

        val mainPanel = contentPane
        mainPanel.add(BoundDoubleComponentWithColor(windowWidth, windowHeight))
    }
}

class BoundDoubleComponentWithColor(private val windowWidth: Int, private val windowHeight: Int): JComponent() {
    private val radius = 30
    private val size = radius * 2

    private val circles = listOf(
        BoundCircle(30, windowHeight - 30, 5, -3),
        BoundCircle(570, windowHeight - 370, -3, 5)
    )
    private val delay = 50
    private var timer: Timer = Timer(delay) {
        // 描画の更新
        circles.forEach { circle ->
            circle.x += circle.incrementalX
            circle.y += circle.incrementalY

            // 反射判定
            val rightEdge = circle.x + radius
            val leftEdge = circle.x - radius

            if(rightEdge >= windowWidth || leftEdge <= 0) {
                circle.incrementalX = -circle.incrementalX
            }

            val upperEdge = circle.y - radius
            val bottomEdge = circle.y + radius

            if(bottomEdge >= windowHeight || upperEdge <= 0) {
                // タイトルバーの分？めり込むけどまあいいや…
                circle.incrementalY = -circle.incrementalY
            }

        }

        repaint()
    }

    init {
        timer.isRepeats = true
        timer.start()
    }

    override fun paintComponent(g: Graphics) {
        // 色の判定
        val x1 = circles[0].x - radius
        val x2 = circles[0].x + radius
        val x3 = circles[1].x - radius
        val x4 = circles[1].x + radius

        val y1 = circles[0].y - radius
        val y2 = circles[0].y + radius
        val y3 = circles[1].y - radius
        val y4 = circles[1].y + radius

        if((x1 in x3..x4 || x2 in x3..x4) &&
            (y1 in y3..y4 || y2 in y3..y4)) {
            g.color = Color.RED
        } else {
            g.color = Color.BLUE
        }

        // 円の描画
        circles.forEach { circle ->
            g.drawOval(circle.x - radius, circle.y - radius, size, size)
            g.fillOval(circle.x - radius, circle.y - radius, size, size)
        }
    }
}

fun main() {
    SwingUtilities.invokeLater {
        BoundDoubleWithColor().isVisible = true
    }
}