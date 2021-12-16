import java.awt.Graphics
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.SwingUtilities
import javax.swing.Timer

class Warp: JFrame() {
    private val windowWidth = 600
    private val windowHeight = 400

    init {
        title = "Warp"
        setSize(windowWidth, windowHeight)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE

        val mainPanel = contentPane
        mainPanel.add(WarpComponent(windowWidth, windowHeight))
    }
}

class WarpComponent(private val windowWidth: Int, private val windowHeight: Int): JComponent() {
    private val radius = 30
    private val size = radius * 2
    private val initX = 0
    private val initY = windowHeight
    private var circleX = initX
    private var circleY = initY
    private var incrementalX = 5
    private var incrementalY = -3
    private val delay = 50
    private var timer: Timer = Timer(delay) {
        circleX += incrementalX
        circleY += incrementalY

        // ワープ判定
        if(circleX > windowWidth) {
            circleX = 0
        }

        if(circleY < 0) {
            circleY = windowHeight
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
        Warp().isVisible = true
    }
}