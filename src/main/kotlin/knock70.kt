import java.awt.Graphics
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.SwingUtilities
import javax.swing.Timer

class Bound: JFrame() {
    private val windowWidth = 600
    private val windowHeight = 400

    init {
        title = "bound"
        setSize(windowWidth, windowHeight)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE

        val mainPanel = contentPane
        mainPanel.add(BoundComponent(windowWidth, windowHeight))
    }
}

class BoundComponent(private val windowWidth: Int, private val windowHeight: Int): JComponent() {
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

        // 反射判定
        if(circleX > windowWidth || circleX < 0) {
            incrementalX = -incrementalX
        }

        if(circleY > windowHeight || circleY < 0) {
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
        Bound().isVisible = true
    }
}