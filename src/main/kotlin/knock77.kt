import java.awt.Color
import java.awt.Graphics
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.SwingUtilities
import javax.swing.Timer

class BoundFill: JFrame() {
    private val windowWidth = 400
    private val windowHeight = 400

    init {
        title = "bound and fill"
        setSize(windowWidth, windowHeight)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE

        val mainPanel = contentPane
        mainPanel.add(BoundFillComponent(windowWidth, windowHeight))
    }
}

data class FillableSquare(
    val x: Int,
    val y: Int,
    val width: Int,
    val height: Int,
    var color: Color
) {
    fun includes(x: Int, y: Int): Boolean {
        return (this.x <= x && x <= this.x + width) && (this.y <= y && y <= this.y + height)
    }
}

class BoundFillComponent(private val windowWidth: Int, private val windowHeight: Int): JComponent() {
    private val radius = 30
    private val size = radius * 2
    private var circleX = 30
    private var circleY = windowHeight - 30
    private val numSquares = 10
    private var incrementalX = 5
    private var incrementalY = -3
    private val squareWidth = windowWidth / numSquares
    private val squareHeight = windowHeight / numSquares
    private val allSquares = mutableListOf<MutableList<FillableSquare>>()

    private val delay = 50
    private var timer: Timer = Timer(delay) {
        // 描画の更新
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
        // 描画更新タイマー
        timer.isRepeats = true
        timer.start()

        // 正方形リスト
        var squareX = 0
        var squareY = 0
        repeat(numSquares) {
            val squares = mutableListOf<FillableSquare>()
            repeat(numSquares) {
                val square = FillableSquare(
                    x = squareX,
                    y = squareY,
                    width = squareWidth,
                    height = squareHeight,
                    color = Color.WHITE
                )
                squares.add(square)
                squareX += squareWidth
            }
            allSquares.add(squares)
            squareY += squareHeight
            squareX = 0
        }
    }

    override fun paintComponent(g: Graphics) {
        // 塗りつぶし
        allSquares.forEach { squares ->
            squares.forEach { square ->
                if(square.includes(circleX, circleY)) {
                    square.color = Color.BLACK
                }
                g.color = square.color
                g.fillRect(square.x, square.y, square.width, square.height)
            }
        }

        // 線の描画
        g.color = Color.BLACK
        allSquares.forEach { squares ->
            squares.forEach { square ->
                g.drawRect(square.x, square.y, square.width, square.height)
            }
        }

        // 円の描画
        g.color = Color.RED

        g.drawOval(circleX - radius, circleY - radius, size, size)
        g.fillOval(circleX - radius, circleY - radius, size, size)


    }
}

fun main() {
    SwingUtilities.invokeLater {
        BoundFill().isVisible = true
    }
}