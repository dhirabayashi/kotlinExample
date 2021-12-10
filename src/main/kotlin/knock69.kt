import java.awt.BorderLayout
import java.awt.Color
import java.awt.GridLayout
import java.util.*
import javax.swing.JFrame
import javax.swing.JPanel

class Checks(private val numSquares: Int): JFrame() {
    private val windowWidth = 600
    private val windowHeight = 600

    init {
        // パネルの描画
        val base = JPanel()
        base.layout = GridLayout(numSquares, numSquares)

        val colors = mutableListOf(Color.BLACK, Color.WHITE)
        repeat(numSquares) {
            repeat(numSquares) {
                val panel = JPanel()
                panel.background = colors[0]
                panel.layout = GridLayout(numSquares, numSquares)

                base.add(panel)

                Collections.rotate(colors, 1)
            }
            if(numSquares % 2 == 0) {
                Collections.rotate(colors, 1)
            }
        }

        contentPane.add(base, BorderLayout.CENTER)

        title = "Checks"
        setSize(windowWidth, windowHeight)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
    }
}

fun main() {
    print("マス目の数: ")
    val numSquares = readLine()!!.toInt()

    if(numSquares < 2) {
        return
    }

    Checks(numSquares)
}