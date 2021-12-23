import java.awt.Graphics
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.SwingUtilities
import javax.swing.Timer

class Parabola: JFrame() {
    private val windowWidth = 600
    private val windowHeight = 400

    init {
        title = "parabola"
        setSize(windowWidth, windowHeight)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE

        val mainPanel = contentPane
        mainPanel.add(ParabolaComponent(windowHeight))
    }
}

class ParabolaComponent(windowHeight: Int): JComponent() {
    private val radius = 30
    private val size = radius * 2
    private val initX = 30
    private val initY = windowHeight - 30
    private var circleX = initX
    private var circleY = initY
    // x軸方向の初速
    private var u = 10
    // y軸方向の初速
    private var v = 25
    // 繰り返し回数
    private var t = 1
    // 重力加速度
    private val a = -1

    private val delay = 50
    private var timer: Timer = Timer(delay) {
        circleX = initX + u * t
        circleY = initY - (v * t + a * t * t / 2)

        t++
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
        Parabola().isVisible = true
    }
}