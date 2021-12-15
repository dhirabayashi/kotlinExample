import java.awt.Graphics
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.SwingUtilities
import javax.swing.Timer

class BoundMark2: JFrame() {
    private val windowWidth = 600
    private val windowHeight = 400

    init {
        title = "bound 2"
        setSize(windowWidth, windowHeight)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE

        val mainPanel = contentPane
        mainPanel.add(BoundComponentMark2(windowWidth, windowHeight))
    }
}

class BoundComponentMark2(private val windowWidth: Int, private val windowHeight: Int): JComponent() {
    private val radius = 30
    private val size = radius * 2
    private val initX = 30
    private val initY = windowHeight - radius
    private var circleX = initX
    private var circleY = initY
    private var incrementalX = 5
    private var incrementalY = -3
    private val delay = 50
    private var timer: Timer = Timer(delay) {
        circleX += incrementalX
        circleY += incrementalY

        // 反射判定
        val rightEdge = circleX + radius
        val leftEdge = circleX - radius

        if(rightEdge >= windowWidth || leftEdge <= 0) {
            incrementalX = -incrementalX
        }

        val upperEdge = circleY - radius
        val bottomEdge = circleY + radius

        if(bottomEdge >= windowHeight || upperEdge <= 0) {
            // タイトルバーの分？めり込むけどまあいいや…
            incrementalY = -incrementalY
        }

        repaint()
    }

    init {
        timer.isRepeats = true
        timer.start()
    }

    override fun paintComponent(g: Graphics) {
        // 円の描画
        g.drawOval(circleX - radius, circleY - radius, size, size)
    }
}

fun main() {
    SwingUtilities.invokeLater {
        BoundMark2().isVisible = true
    }
}