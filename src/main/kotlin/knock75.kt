import java.awt.Graphics
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.SwingUtilities
import javax.swing.Timer

class BoundFive: JFrame() {
    private val windowWidth = 600
    private val windowHeight = 400

    init {
        title = "bound five"
        setSize(windowWidth, windowHeight)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE

        val mainPanel = contentPane
        mainPanel.add(BoundFiveComponent(windowWidth, windowHeight))
    }
}

class BoundFiveComponent(private val windowWidth: Int, private val windowHeight: Int): JComponent() {
    private val radius = 30
    private val size = radius * 2
    private val initX = 30
    private val initY = windowHeight - 30

    private val circles = listOf(
        BoundCircle(initX, initY, 1, -5),
        BoundCircle(initX, initY, 2, -4),
        BoundCircle(initX, initY, 3, -3),
        BoundCircle(initX, initY, 4, -2),
        BoundCircle(initX, initY, 5, -1),
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
        // 円の描画
        circles.forEach { circle ->
            g.drawOval(circle.x - radius, circle.y - radius, size, size)
        }
    }
}

fun main() {
    SwingUtilities.invokeLater {
        BoundFive().isVisible = true
    }
}